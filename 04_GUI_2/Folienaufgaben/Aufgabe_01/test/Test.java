package test;

import test3.Test3;
import test4.Test4;

public class Test {

    public String text = "Hallo";
    protected int value = 12;

    protected void printText(){
        System.out.println(text);
    }

    protected void add(int i){
        printText();
    }

    public static void main(String[] args) {
        Test  test1 = new Test();
        test1.printText();
        Test2 test2 = new Test2();
        test2.add(8);
        Test3 test3 = new Test3();
        test3.AccessAttributeTest();
        Test4 test4 = new Test4();
        test4.add(3000);
    }
}