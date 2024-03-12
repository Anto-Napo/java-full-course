package com.javafullcourse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
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