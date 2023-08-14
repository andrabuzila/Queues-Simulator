import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileData {
    private String fileName = "text.txt";
    File file = new File("text.txt");
    File file1 = new File("text1.txt");
    File file2 = new File("text2.txt");
    File file3 = new File("text3.txt");
    public void createFile() throws IOException {
        file3.createNewFile();
    }

    public void writeInFile(String s) throws IOException {
        try {
            FileWriter write = new FileWriter("D:\\PT_30229_Buzila_Andra_Assignmenttt\\text3.txt",true);
            BufferedWriter buffWr = new BufferedWriter(write);
            buffWr.append(s);
            buffWr.newLine();
            buffWr.close();
            write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
