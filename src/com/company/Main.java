package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.getValue("a", false);
        main.getValue("a", String.valueOf(1));
        main.getValue("a", new Integer("3"));
    }


    public <T> T getValue(String key, T value) {
        System.out.println(value);
        return value;
    }
}
