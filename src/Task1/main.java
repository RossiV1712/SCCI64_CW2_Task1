package Task1;

public class main {
    public static void main(String[] args) {

        char[] Testing = new char[]{'a', 'b', 'x', 'q', 'z', 'e', 'w'};
        CustString Test = new CustString(Testing);
        System.out.println(Test.toString());
        System.out.println(Test.getLength());
        System.out.println(Test.getPosition('Q'));
    }
}
