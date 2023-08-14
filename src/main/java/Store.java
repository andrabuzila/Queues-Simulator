import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Store extends Thread {
    private AtomicInteger time = new AtomicInteger();
    private List<Queuee> queues = new ArrayList<>();
    private List<Client> allClients = new ArrayList<>();
    private List<Client> toRemove = new ArrayList<>();
    private List<Integer> peakTime = new ArrayList<>();
    private List<Integer> peakHourClients = new ArrayList<>();
    private int nbOfQueues;
    private int timeSimulation;
    private int waitingTime;
    private int client1;
    private int serviceTime;
    private int peakHourClients1;
    private int peakHourClientsCompared;
    private FileData fData;
    private ClassView classview;

    public void setTimeSimulation(int timeSimulation) {
        this.timeSimulation = timeSimulation;
    }

    public Store(List<Queuee> l1, List<Client> l2, int nbOfQueues, int timeS, ClassView v) throws IOException {
        this.queues=l1;
        this.allClients=l2;
        this.nbOfQueues=nbOfQueues;
        this.timeSimulation = timeS;
        this.fData = new FileData();
        this.classview = v;
        fData.createFile();
    }

    public void addClient(int id,int minArr, int maxArr, int minSer, int maxSer){
        Random r = new Random();
        int arrival=r.nextInt(maxArr-minArr)+minArr;
        int service=r.nextInt(maxSer-minSer)+minSer;
        Client c = new Client(id,arrival,service);
        allClients.add(c);
    }

    public void setNbOfQueues(int nbOfQueues) {
        this.nbOfQueues = nbOfQueues;
    }

    public int getNbOfQueues() {
        return nbOfQueues;
    }
    public void addQueue(Queuee q){
        queues.add(q);
    }

    public Queuee minQueue(){
        int minWaitingTime=queues.get(0).getWaitingPeriod();
        Queuee q1=null;
        for(Queuee q:queues){
            if(minWaitingTime>q.getWaitingPeriod())
                minWaitingTime=q.getWaitingPeriod();
        }
        for(Queuee q:queues) {
            if (minWaitingTime == q.getWaitingPeriod()){
                q1 = q;
                break;
            }
        }
        waitingTime+=minWaitingTime;
        return q1;
    }

    @Override
    public synchronized void run(){
        for(Queuee q:queues){
            q.start();
            q.setVariabila(true); }
        while(time.get()<=timeSimulation){
            String s="Time "+time.get()+"\n";
            for(Client c:allClients)
                if(c.gettArrival()==time.get())
                    if(c.gettArrival()+c.gettService()<=timeSimulation){
                        Queuee q1=minQueue();
                        q1.addToQueue(c);
                        waitingTime+=c.gettService();
                        client1++;
                        serviceTime+=c.gettService(); }
            for(Client c: allClients)
                if(c.gettArrival()==time.get())
                    toRemove.add(c);
            allClients.removeAll(toRemove);
            s+="Waiting clients: ";
            if(allClients.size()!=0){
                for(Client c:allClients)
                        s+=c.toString()+", ";
                s+="\n"; }
            else{
                s+="closed\n"; }
            for(Queuee q:queues){
                s+="Queue "+q.getId()+":";
                if(!q.getClients().isEmpty())
                    for (Client c : q.getClients()){
                        peakHourClients1++;
                        s += c.toString() + ", ";}
                else
                    s+="closed";
                s+="\n"; }
            peakHourClients.add(peakHourClients1);
            peakHourClients1=0;
            System.out.println(s);
            classview.setPane(s);
            try {
                fData.writeInFile(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try{
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time.incrementAndGet();
            if(time.get()>timeSimulation)
                for(Queuee q: queues)
                    q.setVariabila(false); }
        peakHourClients1=peakHourClients.get(0);
        for(int i= 0;i<peakHourClients.size();i++){
            peakHourClientsCompared=peakHourClients.get(i);
            if(peakHourClients1<peakHourClientsCompared)
                peakHourClients1=peakHourClientsCompared;}
        for(int i=0 ;i<peakHourClients.size();i++){
            if(peakHourClients.get(i).compareTo(peakHourClients1)==0)
                peakTime.add(i);
        }
        try {
            fData.writeInFile("Average waiting time is: "+(float) waitingTime/client1+"\n"+"Average service time is: "+(float) serviceTime/client1+"\n"+"Peak hour is: "+peakTime+" and the number of clients is "+peakHourClients1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
