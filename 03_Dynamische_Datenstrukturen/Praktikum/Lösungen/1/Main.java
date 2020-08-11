public class Main {
    public static void main(String[] args) {
        NodeList list = new NodeList();
        for(int i = 0; i < 100; i++){
            list.add(i);
        }

        for(int i = 0; i < list.getLength(); i++){
            System.out.println(list.get(i));
        }
    }    
}