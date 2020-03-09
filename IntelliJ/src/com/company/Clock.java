package com.company;

public class Clock {

    //Access modifiers are the private or public to encapsulate the variables

    private int hours, minutes, seconds; //Instance or State Variables

    public Clock(int hours, int minutes, int seconds){
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    } //A constructor with a formal parameter list

    public void setTime(int hours, int minutes, int seconds) {
        if ((hours >= 0 && hours < 24)) {
            if ((minutes >= 0 && minutes < 60)) {
                if ((seconds >= 0 && seconds < 60)) {
                    this.hours = hours;
                    this.minutes = minutes;
                    this.seconds = seconds;
                } else {
                    //Error in seconds
                }
            } else {
                //Error in minutes
            }
        } else {
            //Error in hours
        }
    } //A method to set the time (No return value)
    //The hours, minutes and seconds are formal parameter list
    public void secondElapsed() {
        if (seconds < 59) seconds++;
        else {
            seconds = 0;
            if (minutes < 59) minutes++;
            else {
                minutes = 0;
                hours = hours < 23 ? hours + 1 : 0;
            }
        }
    } //A method to add a second onto the time (No return value)

    public int getHours() {
        return hours;
    } //A method to return the hours as an int

    public int getMinutes() {
        return minutes;
    } //A method to return the hours as an int

    public int getSeconds() {
        return seconds;
    } //A method to return the hours as an int

    public String getTime() {
        return (hours <= 9 ? "0" + hours : hours) + ":" + (minutes <= 9 ? "0" + minutes : minutes) + ":" + (seconds <= 9 ? "0" + seconds : seconds);
    } //A method to return the time as a string (hh:mm:ss)
}
