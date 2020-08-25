import java.io.FileReader;
import java.io.IOException;

public class FileLeser {

    static String input_path = "output.txt";
    static FileReader reader = null;
    
    public static void lesen(){
        try {
            reader = new FileReader(input_path);
            char[] input = new char[5000];
            reader.read(input);
            System.out.println(input);
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally{
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}    