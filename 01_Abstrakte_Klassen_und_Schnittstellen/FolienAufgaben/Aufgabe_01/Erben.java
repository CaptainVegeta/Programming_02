public class Erben extends HalloWelt{

    void extending(){
        String test = super.toString();
        System.out.printf(test+"%n->Hallo Mond");
    }
}