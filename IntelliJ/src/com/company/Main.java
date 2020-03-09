package com.company;

public class Main {

    public static void main(String[] args) {
        Clock c1 = new Clock(23,59,59); //Use the constructor method by using "Clock" followed by the name for the object, use the second "Clock" (class) as a blueprint to follow
        Clock c2 = new Clock(23,59,59); //The ints are Actual Parameters, all of this is an object instantiation

        System.out.println("C1 - " + c1.getTime());
        System.out.println("C2 - " + c2.getTime());

        c1.secondElapsed(); //Run the method "secondElapsed" from the Clock class for the c1 object

        System.out.println("C1 - " + c1.getTime());
        System.out.println("C2 - " + c2.getTime());

        c1.setTime(50,62,63);
        System.out.println("C1 - " + c1.getTime());

        c2.setTime(5,12,26);
        System.out.println("C2 - " + c2.getTime());

        Clock c3 = new Clock(12,58,6);
        System.out.println("C3 - " + c3.getTime());
    }
}