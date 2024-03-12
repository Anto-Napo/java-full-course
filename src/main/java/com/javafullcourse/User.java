package com.javafullcourse;

import java.util.ArrayList;

public class User { //! Abstract: If the class would be abstract instead of public, the class would not be usable to create objects, but only Student would be. It's useful if we want to create multiple classes with the same base.
    private String name;
    private String membership = "Bronze"; // Default value

    //! Static data members & methods
    //? Make us able to access an element without having the need to create an instance of the class.
    public static ArrayList<User> admins;

    public static void printAdminNames() {
        for(User user : admins) {
            System.out.println(user);
        }
    }

    //! Method overriding
    public String toString() {
        return getName() + " " + getMembership();
    }
    public boolean equals(User u2) {
        return getName() == u2.getName() && getMembership() == u2.getMembership();
    }

    //! Constructor
    public User() {
        // Empty one to be able to create an object without any parameters.
    }
    public User(String name, String membership) {
        setName(name); //? Don't do this.name = name because it wouldn't be efficient
        setMembership(membership);
    }
    public User(String name, Membership membership) {
        setName(name);
        setMembership(membership.name());
    }

    //! Getter & setters
    void setName(String name) {
        this.name = name;
    }
    String getName() {
        return this.name;
    }

    void setMembership(String membership) {
        this.membership = membership;
    }
    public enum Membership {
        Bronze, Silver, Gold;
    }
    void setMembership(Membership membership) { //! Overloading
        this.membership = membership.name();
    }
    String getMembership() {
        return this.membership;
    }
}
