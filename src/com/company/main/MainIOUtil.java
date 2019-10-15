package com.company.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainIOUtil {

	public static void main(String[] args) {
		File file = new File("test2.txt");
		FileInputStream in = null;
		try {
			in = new FileInputStream(file);
			byte[] bytes = new byte[512];
			int size = 0;
			StringBuffer sb = new StringBuffer();
			while((size = in.read(bytes)) != -1 ) {
				System.out.println("????????????" + size);
				sb.append(new String(bytes));
			}
			System.out.println("???????" + sb);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}

}
