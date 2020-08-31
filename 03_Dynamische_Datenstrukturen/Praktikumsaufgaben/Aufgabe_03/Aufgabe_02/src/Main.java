import java.util.ArrayList;

public class Main {

    static NodeList<Integer> nodeList = new NodeList<Integer>();
    static ArrayList<Integer> arrayList = new ArrayList<Integer>();
    static int anzahl = 50000;

    public static void main(String[] args) {
        setNodeList();
        setArrayList();

        addNodeList(1);
        addArrayList(1);

        addNodeList(3);
        addArrayList(3);

        removeFromNodelist(1000);
        removeFromArrayList(1000);
    }

    public static void setNodeList(){
        long startNodelist = System.currentTimeMillis();
        for (int i = 0; i < anzahl; i++) {
            nodeList.add(i);
        }
        long endNodeList = System.currentTimeMillis();
        System.out.println("Time to fill NodeList: "+(endNodeList - startNodelist));
    }

    public static void setArrayList(){
        long startArrayList = System.currentTimeMillis();
        for (int i = 0; i < anzahl; i++) {
            arrayList.add(i);
        }
        long endArrayList = System.currentTimeMillis();
        System.out.println("Time to fill ArrayList: "+(endArrayList - startArrayList));
    }
    
    public static void addNodeList(int x){
        long startNodelist = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < anzahl; i+=x) {
            sum += nodeList.get(i);
        }
        System.out.println("NodeList adding with "+x+" steps: "+sum);
        long endNodeList = System.currentTimeMillis();
        System.out.println("Time to add NodeList: "+(endNodeList - startNodelist));
    }

    public static void addArrayList(int x){
        long startArrayList = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < anzahl; i+=x) {
            sum += arrayList.get(i);
        }
        System.out.println("ArrayList adding with "+x+" steps: "+sum);
        long endArrayList = System.currentTimeMillis();
        System.out.println("Time to add ArrayList: "+(endArrayList - startArrayList));
    }

    public static void removeFromNodelist(int x){
        long startNodelist = System.currentTimeMillis();
        for (int i = 0; i < x; i++) {
            nodeList.remove(i);
        }
        System.out.println("NodeList removed "+x+" objects.");
        long endNodeList = System.currentTimeMillis();
        System.out.println("Time to remove from NodeList: "+(endNodeList - startNodelist));
        System.out.println("NodeList size is: "+nodeList.getLength());
    }

    public static void removeFromArrayList(int x){
        long startArrayList = System.currentTimeMillis();
        for (int i = 0; i < x; i++) {
            arrayList.remove(i);
        }
        System.out.println("ArrayList removed "+x+" objects.");
        long endArrayList = System.currentTimeMillis();
        System.out.println("Time to remove from ArrayList: "+(endArrayList - startArrayList));
        System.out.println("ArrayList size is: "+arrayList.size());
    }
}

