import java.io.*;

public class FileLeser {

    static String input_path = "output.txt";
    
    public static void lesen(){
        try {
            FileReader reader = new FileReader(input_path);
            char[] input = new char[500];
            reader.read(input);
            System.out.println(input);
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}    