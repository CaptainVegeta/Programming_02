package Kapitel3_Dynamische_Datenstrukturen.Praktikum.Aufgabe_1_und_2;

public class Hauptklasse {
    
    public static void main(String[] args) {
        aufgabe1();
        aufgabe2();
    }

    public static void aufgabe1(){
        NodeList nl = new NodeList();
        nl.add("Eintrag 1");
        nl.add("Eintrag 2");
        nl.add("Eintrag 3");
        nl.add("Eintrag 4");
        nl.add("Eintrag 5");
        nl.add("Eintrag 6");

        System.out.println(String.format("Länge der Liste: %d", nl.getLength()));
        System.out.println(String.format("Objekt an der 4. Stelle (Index 3): %s", nl.get(3)));
        for (int i = 0; i < nl.getLength(); i++) {
            System.out.println(nl.get(i));
        }
    }

    public static void aufgabe2(){
        // 1. 0 bis 100
        compare_lists(100);

        // 2. 0 bis 10000
        compare_lists(10000);

        // 3. 0 bis 50000
        compare_lists(50000);

        // 4. 0 bis 100000
        compare_lists(100000);

    }

    public static int[] int_array(int length){
        int[] integers = new int[length + 1];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = i;
        }
        return integers;
    }

    public static NodeList int_node_list(int length){
        NodeList nl = new NodeList();
        for (int i = 0; i <= length; i++) {
            nl.add(i);
        }
        return nl;
    }

    public static void compare_lists(int length){
        NodeList nl = int_node_list(length);
        int[] int_array = int_array(length);
        int sum;
        long time_before;
        long time_after;

        sum = 0;
        time_before = System.currentTimeMillis();
        for (int i = 0; i < int_array.length; i++) {
            sum += int_array[i];
        }
        time_after = System.currentTimeMillis();
        System.out.println(String.format("Summe: %d, benötigte Zeit: %d", sum, (time_after - time_before)));

        sum = 0;
        Object object;
        time_before = System.currentTimeMillis();
        for (int i = 0; i < nl.getLength(); i++) {
            object = nl.get(i);
            if (object instanceof Integer){
                Integer integer = (Integer) object;
                sum += integer.intValue();
            }
        }
        time_after = System.currentTimeMillis();
        System.out.println(String.format("Summe: %d, benötigte Zeit: %d", sum, (time_after - time_before)));

    }
}