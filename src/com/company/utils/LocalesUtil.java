package com.company.utils;

import java.util.Locale;

public class LocalesUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale loc = Locale.CHINESE;
		Locale defLocale = Locale.getDefault();
		Locale.setDefault(Locale.FRANCE);
		Locale[] avaLocale = Locale.getAvailableLocales();
		for (int i = 0; i < avaLocale.length; i++) {
			loc = avaLocale[i];
			System.out.println(loc.getCountry() + " " + loc.getDisplayCountry() + " " + loc.getLanguage() + " " + loc.getDisplayLanguage());
		}
	}

}
