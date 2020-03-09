package com.Switch;

public class AdjustableSwitch extends Switch {

    private float level;

    public AdjustableSwitch(float level) {
        super(level != 0);
        this.level = level;
    }

    public void setLevel(float level) {
        this.level = level;
        SetOn(level != 0);
    }

    public float getLevel() {
        return isOn() ? level : 0;
    }

    public void increaseSwitch() {
        this.level++;
    }

    public void decreaseSwitch() {
        this.level--;
    }
}
