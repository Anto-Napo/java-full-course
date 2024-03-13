package com.javafullcourse;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //! Variables & datatype
        String name = "Anto";
        int age = 15;
        float badGpa = 2.1f; // Double if no 'f'
        double gpa = 3.5; // ALWAYS use double except if accuracy is not important
        System.out.println("Name: " + name + ", Age: " + age + ", badGpa: " + badGpa + ", gpa: " + gpa);

        //! Loops
        for(int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        int doVar = 0;
        do {
            System.out.println("Doing thing");
            doVar++;
        } while (doVar < 3);

        boolean whileVar = true;
        while(whileVar) {
            System.out.println("While looping");
            whileVar = false;
        }

        //! Conditional
        boolean isGood = true;
        if(isGood) {
            System.out.println("Yep");
        } else {
            System.out.println("Nope");
        }

        //! Switches
        int switchNb = 3;
        switch (switchNb) {
            case 2:
                System.out.println(2);
                break;
            case 3:
                System.out.println(3);
                break;
            default:
                System.out.println("Unknown number");
        }

        //! Arrays
        String[] carBrands = {"Volvo", "Porsche", "Ferrari", "Citroën"};
        for (String carBrand : carBrands) { // (int i = 0; i < carBrands.length; i++)
            System.out.println(carBrand);
        }

        //! ArrayList
        // import java.util.ArrayList
        ArrayList<String> pcBrands = new ArrayList<String>();
        pcBrands.add("HP");
        pcBrands.add("DELL");
        pcBrands.add("AMD");
        pcBrands.add("NVidia");
        System.out.println(pcBrands);

        //! LinkedList
        // import java.util.LinkedList
        LinkedList<String> servers = new LinkedList<String>();
        servers.add("Paladium");
        servers.add("Hypixel");
        servers.add("Funcraft");
        System.out.println(servers);

        //? Arr is used to store and access data & Link is used to manipulate data.

        //! HashMap
        // import java.util.HashMap
        HashMap<String, String> capitalCities = new HashMap<String, String>();
        capitalCities.put("France", "Paris");
        capitalCities.put("England", "London");
        capitalCities.put("Spain", "Madrid");
        capitalCities.put("USA", "Washington");
        System.out.println(capitalCities.get("France"));
        for(String i : capitalCities.keySet()) {
            System.out.println(i);
        }
        for(String i : capitalCities.values()) {
            System.out.println(i);
        }

        //! TreeMap
        // import java.util.TreeMap
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        treeMap.put(3, "Three");
        treeMap.put(1, "One");
        treeMap.put(2, "Two");
        treeMap.put(4, "Four");

        System.out.println("TreeMap: " + treeMap);

        int keyToFind = 2;
        if (treeMap.containsKey(keyToFind)) {
            String value = treeMap.get(keyToFind);
            System.out.println("Value for key " + keyToFind + ": " + value);
        } else {
            System.out.println("Key " + keyToFind + " not found in the TreeMap.");
        }

        for (Integer key : treeMap.keySet()) {
            String value = treeMap.get(key);
            System.out.println("Key: " + key + ", Value: " + value);
        }

        //? TreeMap sort elements, where HashMap doesn't. However, it may be slower

        //! Methods (Functions)
        myMethod();
        callGuy("Anto", 15);
        callGuy("Elou", 11);
        System.out.println(addFive(3));
        System.out.println(addInt(3, 5));
        System.out.println(addDouble(2.3, 6.1));
        System.out.println(rec(10));

        System.out.println("\nINTERMEDIATE");

        //! OOP, take a look at User.java
        //? Overloading vs. Overriding. Overloading means that a method with the same name is being modified with different parameters within the same function (Constructors). Overriding means that a method declared in a superclass is being modified with different parameters (.toString()).
        User u = new User(); // <- default constructor
        //* If values were public, u.name = "Anto"; But that'd not be secure.
        u.setName("Anto");
        u.setMembership("Gold"); // using String

        User u2 = new User();
        u2.setName("Elouan");
        u2.setMembership(User.Membership.Silver); // using enum

        System.out.println(u.getName());
        System.out.println(u2.getMembership());

        User u3 = new User("Julien", User.Membership.Bronze); // Using constructor
        User u4 = new User("Nicolas", "Silver"); // Constructor overloading
        User u5 = new User("Nicolas", User.Membership.Silver);
        System.out.println(u3.toString()); // Method overriding
        System.out.println(u4.equals(u5));

        ArrayList<User> users = new ArrayList<>(); //* Using a list
        users.add(u);
        users.add(new User("Lucas", User.Membership.Gold));
        System.out.println(users.get(0).toString());
        for(User user : users) {
            System.out.println(user.toString());
        }

        User.admins = new ArrayList<>(); // Static data members
        User.admins.add(new User("Antoine", User.Membership.Bronze));
        System.out.println(User.admins.get(0));
        User.admins.add(new User("Thibault", User.Membership.Silver));
        User.printAdminNames(); // Static method

        Student s = new Student(); // inheritance
        s.setVerified(true);
        System.out.println(s.getVerified());
        Student s2 = new Student("JP", User.Membership.Gold, true);
        System.out.println(s2.toString());
        s2.haveBreakfast();

        //! Exception handling
        int[] numbs = {1, 2, 3};
        try {
            System.out.println(numbs[10]);
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e);
        } finally {
            System.out.println("Try catch is finished");
        }

        int myAge = 15;
        //? Commented so there's no errors
        /*try {
            checkAge(myAge);
        } catch (CustomException e) {
            System.out.println("Error: " + e.getMessage());
        }*/

        //! Input & Output
        File file = new File("textFile.txt");
        try {
            if(file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("Already existing file.");
            }

            FileWriter writer = new FileWriter(file);
            writer.write("Hi mom");
            writer.close();

            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //! Threads
        System.out.println(Thread.activeCount()); //? Will return one, the main thread

        System.out.println(Thread.currentThread().getName()); // main
        Thread.currentThread().setName("The Main Thread");
        System.out.println(Thread.currentThread().getName()); // The Main Thread

        System.out.println(Thread.currentThread().getPriority()); // 5 (Range of 1-10)
        Thread.currentThread().setPriority(7);
        System.out.println(Thread.currentThread().getPriority()); // 10

        System.out.println(Thread.currentThread().isAlive()); // true if alive

        for(int i = 3; i >= 0; i--) {
            System.out.println(i);
            Thread.sleep(1); // Countdown with threads
        }
        System.out.println("Counter done");

        MyThread thread2 = new MyThread();
        System.out.println(thread2.isAlive()); // False because it isn't started
        thread2.setDaemon(true);
        thread2.start(); // Will execute the run() function
        System.out.println(thread2.isAlive()); // true
        System.out.println(Thread.activeCount()); // 2

        System.out.println(thread2.getName()); // Thread-0 by default, always set a name.
        thread2.setName("Second Thread");
        System.out.println(thread2.getName());

        System.out.println(thread2.getPriority()); // 7 because it gets the priority of the extended one.
        thread2.setPriority(1);
        System.out.println(thread2.getPriority());

        //? There are 2 kinds of thread: user threads and daemon threads.
        //? The user thread is created by default. After all the non-daemon threads finished, the JVM terminates itself.
        //? The daemon thread is a low priority thread that runs on the background and does garbage collection

//*     We can set a thread to daemon by doing `thread2.setDaemon(true);`
        System.out.println(thread2.isDaemon());

        //! Multithreading
        MyThreadMulti thread3 = new MyThreadMulti(); //? 1st way to create a thread

        MyRunnableMulti runnable1 = new MyRunnableMulti();
        Thread thread4 = new Thread(runnable1); //? 2nd way to create a thread. It's preferable to use this method because it can still inherit from another class.

        thread3.start();
        thread3.join(3000); //? Join will pause the other threads, so it begins after this one died or after a delay.
        thread4.start();
        System.out.println("Main continues");

        //? If an error occurs in one of the threads, it will not stop the others.
        //? That happens because the JVM will exit only after all the USER (not daemon) threads are finished.

        //! Network programming
        
    }
    //! Exception handling
    static void checkAge(int age) throws CustomException {
        if(age < 18) {
            throw new CustomException("You have to be more than 18.");
        }
    }

    //! Methods (Functions)
    //? Static means that the function is owned by the class and not by an object of the class.
    //? Void means that the function doesn't return anything.
    //? Public means that every class can access the method, and private that the method can only be called within the same class.
    //Basic
    static void myMethod() {
        System.out.println("Method called");
    }
    // Parameters
    static void callGuy(String name, int age) {
        System.out.println("Name: " + name + ". Age: " + age);
    }
    // Return
    static int addFive(int x) {
        return x + 5;
    }
    // Overloading
    static int addInt(int x, int y) {
        return x + y;
    }
    static double addDouble(double x, double y) {
        return x + y;
    }
    //Recursion
    public static int rec(int k) {
        if (k > 0) {
            return k + rec(k - 1);
        } else {
            return 0;
        }
    }
}