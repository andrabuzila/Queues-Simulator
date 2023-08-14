import java.util.ArrayList;
import java.util.List;

class Queuee extends Thread{

    private List<Client> clients = new ArrayList<>();
    private int id;
    private int timeSimulation;
    private int waitingPeriod;
    private Client currentClient;
    private Boolean variabila;

    public void setVariabila(Boolean variabila) {
        this.variabila = variabila;
    }


    public int getWaitingPeriod() {
        return waitingPeriod;
    }

    public List<Client> getClients() {
        return clients;
    }


    @Override
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTimeSimulation() {
        return timeSimulation;
    }

    public void setTimeSimulation(int timeSimulation) {
        this.timeSimulation = timeSimulation;
    }


    public Queuee(int id, int timeSimulation){
        this.id = id;
        this.timeSimulation = timeSimulation;
    }

    public void addToQueue(Client c){
        this.clients.add(c);
        for(int i=0; i<c.gettService();i++){
            waitingPeriod++;
        }
    }


    @Override
    public void run(){
        while(variabila){
            if(!clients.isEmpty()){
                currentClient=clients.get(0);
                if(currentClient.gettService()>1){
                    currentClient.settService(currentClient.gettService()-1);
                    waitingPeriod--;
                }
                else{
                    if(currentClient.gettService()==1){
                    clients.remove(currentClient);
                    waitingPeriod--;
                    }else{
                        try {
                            throw new Exception("Error");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            try{
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}