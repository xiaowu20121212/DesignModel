package com.company.main;

public class BitTest {
    public static void main(String[] args) {
        int one = 1;
        int two = 1 << 1;
        int three = 1 << 2;
        int four = 1 << 3;
        int five = 1 << 4;
        int type = one | three;

        System.out.println((type & two) == two);
        System.out.println((type & three) == three);
        System.out.println((type & one) == one);


        System.out.println(type | two);
        System.out.println(type | three);
        System.out.println(type | one);

    }
}
