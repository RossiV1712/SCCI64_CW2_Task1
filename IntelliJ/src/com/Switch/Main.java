package com.Switch;

public class Main {

    public static void main(String[] args) {
        Switch S1 = new Switch(false);
        Switch S2 = new Switch(false);
        System.out.println("S1 - " + S1.isOn());
        System.out.println("S2 - " + S2.isOn());

        S1.FlickSwitch();
        System.out.println("Flick Switch S1");

        System.out.println("S1 - " + S1.isOn());
        System.out.println("S2 - " + S2.isOn());

        S2.SetOn(false);
        System.out.println("Set Switch S2 To False");

        System.out.println("S1 - " + S1.isOn());
        System.out.println("S2 - " + S2.isOn());

        AdjustableSwitch AS1 = new AdjustableSwitch(3);
        AdjustableSwitch AS2 = new AdjustableSwitch(0);

        System.out.println("AS1 - " + AS1.getLevel());
        System.out.println("AS2 - " + AS2.getLevel());

        AS1.setLevel(4);
        AS2.setLevel(7);

        System.out.println("AS1 - " + AS1.getLevel());
        System.out.println("AS2 - " + AS2.getLevel());

        AS2.decreaseSwitch();
        System.out.println("AS2 - " + AS2.getLevel());
        AS2.decreaseSwitch();
        AS2.decreaseSwitch();
        AS2.decreaseSwitch();
        AS2.decreaseSwitch();
        AS2.decreaseSwitch();
        AS2.decreaseSwitch();
        System.out.println("AS2 - " + AS2.getLevel());
    }
}
