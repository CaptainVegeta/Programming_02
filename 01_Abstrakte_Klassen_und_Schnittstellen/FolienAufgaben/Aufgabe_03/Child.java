public class Child extends Parent
{
    public Child(){
        super(3);
        parent_result = decrease(parent_result);
        System.out.println(parent_result);
    }
    public int increase(int input){
        input = input * 2;
        return super.increase(input);
    }
    public int decrease(int input){
        return input + 2;
    }
}