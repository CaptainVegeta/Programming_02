public class Parent
{

    public static void main(String[] args) {
        Child kind = new Child();
    }

    int parent_result;

    public Parent(int value){
        value = value + 2;
        parent_result = increase(value);
    }
    public int increase(int input){
        return input + 5;
    }
    public int decrease(int input){
        return input - 9;
    }
}