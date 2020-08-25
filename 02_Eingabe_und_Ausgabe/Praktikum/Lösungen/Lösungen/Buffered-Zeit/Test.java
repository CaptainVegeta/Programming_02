public class Test {
    public static void main(String[] args) {
        BufferedTester tester_1 = new BufferedTester(200, "Hello");
        BufferedTester tester_2 = new BufferedTester(10000, "Hello");
        BufferedTester tester_3 = new BufferedTester(1000000, "Hello");
        BufferedTester tester_4 = new BufferedTester(500000, "HelloWorld");

        tester_1.test();
        tester_2.test();
        tester_3.test();
        tester_4.test();
    }
}