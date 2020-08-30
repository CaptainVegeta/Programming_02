

public class Main {
    static NodeList nodeList = new NodeList();
    static int[] array = new int[50000];

    public static void main(String[] args) {
        fill();
        timeNodelist();
        timeArray();

    }

    public static void fill(){
        for (int i = 0; i < array.length; i++) {
            nodeList.add(i);
            array[i] = i;
        }
    }

    public static void timeArray(){
        long arrayZeit1 = System.currentTimeMillis();
        System.out.println("ArrayZeit1: "+arrayZeit1);
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        long arrayZeit2 = System.currentTimeMillis();
        System.out.println("ArrayZeit2: "+arrayZeit2);
        long arrayZeit = arrayZeit2 - arrayZeit1;
        System.out.println("ArraySumme: "+sum);
        System.out.println("ArrayZeit: "+arrayZeit);
    }

    public static void timeNodelist(){
        long nodeZeit1 = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += (int)nodeList.get(i);
        }
        long nodeZeit2 = System.currentTimeMillis();
        long nodeZeit = nodeZeit2 - nodeZeit1;
        System.out.println("NodeSumme: "+sum);
        System.out.println("NodeZeit: "+nodeZeit);
    }
}

