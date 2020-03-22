package com.company.main;

public class BitTest {
    public static void main(String[] args) {
        int one = 1; //用4个字节二进制表示 00000000 00000000 00000000 00000001  十六进制表示 0x 00 00 00 01    十六进制转十进制计算：1 * 16^0 = 1
        int two = 1 << 1;//用4个字节二进制表示 00000000 00000000 00000000 00000010  十六进制表示 0x 00 00 00 02   十六进制转十进制计算：2 * 16^0 = 2
        int three = 1 << 2;//用4个字节二进制表示 00000000 00000000 00000000 00000100  十六进制表示 0x 00 00 00 04  十六进制转十进制计算：4 * 16^0 = 4
        int four = 1 << 3;//用4个字节二进制表示 00000000 00000000 00000000 00001000  十六进制表示 0x 00 00 00 08 十六进制转十进制计算：8 * 16^0 = 8
        int five = 1 << 4;//用4个字节二进制表示 00000000 00000000 00000000 00010000  十六进制表示 0x 00 00 00 0f  十六进制转十进制计算：15 * 16^0  = 15
        int type = one | three; //二进制表示 00000000 00000000 00000000 00000101    十进制计算：1 * 2^0 + 0 * 2^1 + 1 * 2^2 = 5
        System.out.println("type:" + type);

        System.out.println((type & two) == two);
        System.out.println((type & three) == three);
        System.out.println((type & one) == one);


        System.out.println(type | two);
        System.out.println(type | three);
        System.out.println(type | one);

    }
}
