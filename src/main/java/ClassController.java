import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClassController {
    private final ClassView classview;
    private final Store store;

    ClassController(ClassView view, Store s){
        classview=view;
        store=s;

        classview.addProcessingListener(new procesareDate());
    }

    class procesareDate implements ActionListener{
        String user1Input="";
        String user2Input="";
        String user3Input="";
        String user4Input="";
        String user5Input="";
        String user6Input="";
        String user7Input="";

        @Override
        public void actionPerformed(ActionEvent e) {
            user1Input=classview.getNbOfClients();
            user2Input=classview.getNbOfQueues();
            user3Input= classview.getMaxSimulation();
            user4Input=classview.getMinArrival();
            user5Input=classview.getMaxArrival();
            user6Input= classview.getMinService();
            user7Input= classview.getMaxService();
            try {
                int nbQueues = Integer.parseInt(user2Input);
                for (int i = 0; i < nbQueues; i++) {
                    Queuee qu = new Queuee(i, Integer.parseInt(user3Input));
                    store.addQueue(qu);
                }
                int nbClients = Integer.parseInt(user1Input);
                int minArr = Integer.parseInt(user4Input);
                int maxArr = Integer.parseInt(user5Input);
                int minSer = Integer.parseInt(user6Input);
                int maxSer = Integer.parseInt(user7Input);
                store.setNbOfQueues(nbQueues);
                store.setTimeSimulation(Integer.parseInt(user3Input));
                for (int i = 0; i < nbClients; i++) {
                    store.addClient(i, minArr, maxArr, minSer, maxSer);
                }
                store.start();
            } catch (NumberFormatException numberFormatException) {
                numberFormatException.printStackTrace();
            }
        }
    }
}