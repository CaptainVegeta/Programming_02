public class Main {
    public static int max = 100000;
    private static long tick_start;


    public static void main(String[] args) {
        int[] static_array = new int[max];
        NodeList dynamic_array = new NodeList();

        for(int i = 0; i < max; i++){
            static_array[i] = i;
            dynamic_array.add(i);
        }

        // Test 1
        int sum = 0;
        tick(true);
        for(int i = 0; i < max; i++){
            sum = sum + static_array[i];
        }
        tick(false);

        tick(true);
        sum = 0;
        for(int i = 0; i < max; i++){
            sum = sum + (int) dynamic_array.get(i);
        }
        tick(false);

        // Test 2 optimized
        tick(true);
        sum = 0;
        for(int i = 0; i < max; i++){
            sum = sum + (int) dynamic_array.iterate();
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