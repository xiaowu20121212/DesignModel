package com.company.utils;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class NumberFormatUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��ȡ��֧�ֵ�Local
		Locale[] locs = NumberFormat.getAvailableLocales();
		//��ȡָ��Locale�����ָ�ʽ
		NumberFormat numberfmt = NumberFormat.getNumberInstance(Locale.CANADA);
		//��ȡָ��Locale�Ļ��Ҹ�ʽ
		NumberFormat currencyfmt = NumberFormat.getCurrencyInstance(Locale.CANADA);
		//��ȡָ��Local�İٷֱȸ�ʽ
		NumberFormat percentfmt = NumberFormat.getPercentInstance(Locale.CHINA);
		//��ȡָ��Locale�Ļ��ұ�ʶ��
		Currency currency = Currency.getInstance(Locale.US);
		System.out.println(currency.getCurrencyCode());
		System.out.println(currency.getDisplayName());
		System.out.println(currency.getDisplayName(Locale.US));
		System.out.println(currency.getSymbol());
		System.out.println(currency.getSymbol(Locale.UK));
	}

}
