public class Client {
    public int ID;
    public int tArrival;
    public int tService;

    public Client(int ID, int tArr, int tSer){
        this.ID = ID;
        this.tArrival = tArr;
        this.tService = tSer;
    }

    public int getID() {
        return ID;
    }
    public int gettArrival() {
        return tArrival;
    }
    public int gettService() {
        return tService;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public void settArrival(int tArrival) {
        this.tArrival = tArrival;
    }
    public void settService(int tService) {
        this.tService = tService;
    }
    public String toString(){
        return "("+this.ID+","+this.tArrival+","+this.tService+")";
    }
}
