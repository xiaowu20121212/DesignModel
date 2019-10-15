package com.company.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties p = new Properties();
		p.setProperty("first", "true");
		System.out.println(p.toString());
		File file = new File("property.txt");
		FileOutputStream out = null;
		try {
			 out = new FileOutputStream(file);
			p.store(out, "comment");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch blockg
			e.printStackTrace();
		}finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
