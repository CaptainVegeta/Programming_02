import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedTester {
    public static String path_buffered = "buffered_test.txt";
    public static String path_direct = "direct_test.txt";

    public int number;
    public String word;

    public BufferedTester(int new_number, String new_word){
        number = new_number;
        word = new_word;
    }

    public int testDirect(){
        long time_1;
        long time_2;

        try {
            FileWriter writer = new FileWriter(path_direct);
            time_1 = System.currentTimeMillis();
            for(int i = 0; i < number; i++){
                writer.write(word);
            }
            writer.close();
            time_2 = System.currentTimeMillis();
            return (int)(time_2 - time_1);
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return 0; // Muss einen Wert zurückgeben!
        }
    }

    public int testBuffered(){
        long time_1;
        long time_2;

        try {
            FileWriter writer = new FileWriter(path_buffered);
            BufferedWriter buffered_writer = new BufferedWriter(writer);
            time_1 = System.currentTimeMillis();
            for(int i = 0; i < number; i++){
                writer.write(word);
            }
            buffered_writer.close();
            time_2 = System.currentTimeMillis();
            return (int)(time_2 - time_1);
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return 0; // Muss einen Wert zurückgeben!
        }
    }

    public void test(){
        System.out.println("================");
        System.out.println("Testing with " + number + "x " + word);
        System.out.println("Direct:\t\t" + testDirect());
        System.out.println("Buffered:\t" + testBuffered());
        System.out.println("================");
    }
}