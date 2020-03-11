package Task1;

public class main {
    public static void main(String[] args) {

//        char[] Testing = new char[]{'a', 'b', 'x', 'q', 'z', 'e', 'w'};
//        CustString Test = new CustString(Testing);
//        System.out.println(Test.toString());
//        System.out.println(Test.getLength());
//        System.out.println(Test.getPosition('q'));
//        Test.setChar(4, 'w');
//        System.out.println(Test.toString());
//        Test.ammendChar('z');
//        Test.appendChar('z');
//        System.out.println(Test.toString());
//        System.out.println(Test.getPosition('w'));

        int[] Test = new int[]{33, 14, 6, 21, 1, 18, 14};
        Sort Numbers = new Sort(Test);
        System.out.println(Numbers.toString());
        Numbers.quickSort();
        System.out.println(Numbers.toString());


    }
}
