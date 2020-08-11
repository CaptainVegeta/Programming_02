import java.util.ArrayList;

public class Main {
    public static int max = 50000;
    private static long tick_start;


    public static void main(String[] args) {
        ArrayList<Integer> arrays = new ArrayList<Integer>();
        NodeList<Integer> nodes = new NodeList<Integer>();

        // Test 1
        System.out.println("Test 1");
        tick(true);
        for(int i = 0; i < max; i++){
            arrays.add(i);
        }
        tick(false);

        tick(true);
        for(int i = 0; i < max; i++){
            nodes.add(i);
        }
        tick(false);
        
        // Test 2
        System.out.println("Test 2");
        int sum = 0;
        tick(true);
        for(int i = 0; i < max; i++){
            sum = sum + arrays.get(i);
        }
        tick(false);

        tick(true);
        sum = 0;
        nodes.resetIteration();
        for(int i = 0; i < max; i++){
            sum = sum + nodes.iterate();
        }
        tick(false);

        // Test 3
        System.out.println("Test 3");
        tick(true);
        sum = 0;
        for(int i = 0; i < max; i+=3){
            sum = sum + arrays.get(i);
        }
        tick(false);

        tick(true);
        sum = 0;
        nodes.resetIteration();
        for(int i = 0; i < max; i+=3){
            sum = sum + nodes.iterate();
        }
        tick(false);

        // Test 4
        System.out.println("Test 4");
        tick(true);
        for(int i = 0; i < max / 2; i++){
            arrays.remove(0);
        }
        tick(false);

        tick(true);
        for(int i = 0; i < max / 2; i++){
            nodes.remove(0);
        }
        tick(false);
    } 
    
    private static void tick(boolean start){
        if(start){
            tick_start = System.currentTimeMillis();
        } else {
            long tick_end = System.currentTimeMillis();
            float tick = (tick_end - tick_start);
            System.out.println(tick);   
        }
    }
}