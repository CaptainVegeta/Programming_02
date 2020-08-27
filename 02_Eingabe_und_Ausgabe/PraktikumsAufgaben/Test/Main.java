import java.io.File;

public class Main {

    public static void main(String[] args) {

        long zeit_1;
        long zeit_2;
        long zeit;

        System.out.println(System.currentTimeMillis());

        System.out.println(System.currentTimeMillis());
        
        zeit_1 = System.currentTimeMillis();
        SimplifiedDelay.delay(100);
        zeit_2 = System.currentTimeMillis();
        zeit   = zeit_2 - zeit_1;
        System.out.println(zeit);

        checkFile();
    }

    public static void checkFile(){
        File f = new File("C:\\Users\\murat\\Desktop\\TEKO\\Semester_04\\Programming_02\\02_Eingabe_und_Ausgabe\\PraktikumsAufgaben\\Test\\test.txt");
        if (f.exists()){
            System.out.println("Exists"); 
        } else {
            System.out.println("Does not Exists"); 
        }
        File g = new File("test.txt");
        if (g.exists()){
            System.out.println("Exists"); 
        } else {
            System.out.println("Does not Exists"); 
        }
    }
}