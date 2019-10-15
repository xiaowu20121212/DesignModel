package com.company.utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class StringUtils {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String f = "http://tile.openstreetmap.org/%d/%d/%d.png";
		System.out.println();
		try {
			URL url = new URL(String.format(f, 1,2,3));
			System.out.println(url.getProtocol());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
