import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * BufferedTester
 */
public class BufferedTester {

    int anzahl;
    String testwort;
    String output_path_direct = "direct.txt";
    String output_path_buffered = "buffered.txt";

    long zeit_direct_1;
    long zeit_direct_2;
    long zeit_direct;

    long zeit_buffered_1;
    long zeit_buffered_2;
    long zeit_buffered;

    FileWriter fileWriter = null;
    BufferedWriter bufferedWriter = null;
    FileWriter writer;

    BufferedTester(int anzahl, String testWort){
        this.anzahl = anzahl;
        this.testwort = testWort;
    }

    //Die Klasse besitzt eine Methode testDirect(), welches den Test für den direkten
    //Schreibzugriff durchführt und die aufgewendete Zeit in Millisekunden zurück gibt.
    public long testDirect(){
        try {
            fileWriter = new FileWriter(output_path_direct);

            zeit_direct_1 = System.currentTimeMillis();
            for (int i = 0; i < anzahl; i++) {
                fileWriter.write(testwort+"\n");
            }

            fileWriter.close();
            zeit_direct_2 = System.currentTimeMillis();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return zeit_direct = zeit_direct_2 - zeit_direct_1;
    }

    //Die Klasse besitzt eine Methode testBuffered(), welches den Test für den gepufferten
    //Schreibzugriff durchführt und die aufgewendete Zeit in Millisekunden zurück gibt.
    public long testBuffered(){
        try {
            writer = new FileWriter(output_path_buffered);
            bufferedWriter = new BufferedWriter(writer);

            zeit_buffered_1 = System.currentTimeMillis();
            for (int i = 0; i < anzahl; i++) {
                bufferedWriter.write(testwort+"\n");
            }

            bufferedWriter.close();
            zeit_buffered_2 = System.currentTimeMillis();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return zeit_buffered = zeit_buffered_2 - zeit_buffered_1;
    }

    //Die Klasse besitzt eine Methode test(), welches beide tests mit den oberen Methoden
    //durchführt und beide Werte formatiert an die Konsole ausgibt.
    public void test(){

        System.out.println("================");
        System.out.println("Testing with " + anzahl + "x " + testwort);
        System.out.println("Direct:\t\t" + testDirect());
        System.out.println("Buffered:\t" + testBuffered());
        System.out.println("================");
    }
}