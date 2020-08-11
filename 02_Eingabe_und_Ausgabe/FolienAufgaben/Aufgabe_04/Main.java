public class Main {

    public static void main(String[] args) {

        MeineKlasse mein_objekt1;
        MeineKlasse mein_objekt2;
        MeineKlasse mein_objekt3;
        mein_objekt1 = new MeineKlasse();
        mein_objekt2 = mein_objekt1;
        mein_objekt3 = mein_objekt1;
        mein_objekt3.text = "Hallo";
        mein_objekt2.text = "Welt";
        System.out.println(mein_objekt3.text);
        System.out.println(mein_objekt1.text);
       
    }

}