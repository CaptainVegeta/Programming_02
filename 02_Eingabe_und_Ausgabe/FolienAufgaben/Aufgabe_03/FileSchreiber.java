import java.io.FileWriter;
import java.io.IOException;

/**
 * FileWriter
 */
public class FileSchreiber {

    public static void main(String[] args) {

        int output_text = 2;
        String output_path = "output.txt";

        try {
            FileWriter writer = new FileWriter(output_path);
            for (; output_text <= 1000; output_text += 2){
                writer.write(output_text + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        FileLeser.lesen();
    }
}