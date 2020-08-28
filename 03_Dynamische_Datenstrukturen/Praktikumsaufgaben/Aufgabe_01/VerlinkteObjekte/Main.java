public class Main {
    public static void main(String[] args) {
        NodeList liste = new NodeList();
        liste.add(1);
        liste.add(2);
        liste.add(3);
        liste.add(4);
        liste.add(5);

        for (int i = 0; i < liste.getLength(); i++) {
            Object content = liste.get(i);
            System.out.println(content); 
        }

        System.out.println("***********");
        liste.remove(0);

        for (int i = 0; i < liste.getLength(); i++) {
            Object content = liste.get(i);
            System.out.println(content); 
        }
    }
}