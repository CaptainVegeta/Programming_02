import java.io.FileWriter;
import java.io.IOException;

/**
 * FileWriter
 */
public class FileSchreiber {

    public static void main(String[] args) {

        int output_text = 2;
        String output_path = "output.txt";
        FileWriter writer = null;

        try {
            writer = new FileWriter(output_path);
            for (; output_text <= 1000; output_text += 2){
                writer.write(output_text + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        FileLeser.lesen();
    }
}