package com.company.main;

public class MainFileUtil {

	public static void main(String[] args) {
		int i = 0;
		if (i++ == 1) {//表示先先判断 再执行加1操作
			System.out.println("true");
		}
		System.out.println("i = " + i);
		if (++i == 2) { //表示先加1操作，再执行判断
			System.out.println("true");
		}
		System.out.println("i = " + i);
	}

}
