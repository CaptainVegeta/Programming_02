

public class Main {

    public static void main(String[] args) {
        NodeList<Integer> nodeList1 = new NodeList<Integer>();
        nodeList1.add(2);
        int test1;
        test1 = nodeList1.get(0);
        System.out.println(test1);

        NodeList<String> nodeList2 = new NodeList<String>();
        nodeList2.add("Murat");
        String test2;
        test2 = nodeList2.get(0);
        System.out.println(test2);
    }
}

