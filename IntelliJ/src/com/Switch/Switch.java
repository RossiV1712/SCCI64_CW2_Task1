package com.Switch;

public class Switch {

    private boolean isOn = false;

    public Switch(boolean x) {
        this.isOn = x;
    }

    public void FlickSwitch() {

        if (this.isOn == true) {
            this.isOn = false;
        }
        else {
            this.isOn = true;
        }

    }

    public boolean isOn() {
        return this.isOn;
    }

    public void SetOn(boolean y) {
        this.isOn = y;
    }
}