package com.javafullcourse;

//! Inheritance
//? Student objects still have the type User
public class Student extends User implements Resident {
    private boolean verified = false;
    private boolean breakfast = false;

    public Student(){};
    public Student(String name, String membership, boolean verified) {
        setName(name);
        setMembership(membership);
        setVerified(verified);
    }
    public Student(String name, Membership membership, boolean verified) {
        setName(name);
        setMembership(membership);
        setVerified(verified);
    }

    public String toString() {
        return getName() + " " + getMembership() + " " + getVerified();
    }

    void setVerified(boolean verified) {
        this.verified = verified;
    }
    boolean getVerified() {
        return this.verified;
    }

    //! Interfaces
    void setBreakfast(boolean breakfast) {
        this.breakfast = breakfast;
    }
    public void haveBreakfast() {
        if(breakfast) {
            System.out.println(getName() + " has breakfast.");
        } else {
            System.out.println(getName() + " has no breakfast.");
        }
    }
}
