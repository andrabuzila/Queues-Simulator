import java.io.IOException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException {
        ClassView vedere = new ClassView();
        Store s = new Store(new ArrayList<>(), new ArrayList<>(), 0, 0,vedere);
        ClassController controller = new ClassController(vedere,s);
        vedere.setVisible(true);
    }
}
