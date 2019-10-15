package com.company.decorator;

public class Decorator implements Soureable {
	private Source mSoure;
	public  Decorator(Source source) {
		// TODO Auto-generated constructor stub
		this.mSoure = source;
	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		beforeDecorate();
		this.mSoure.method1();
		afterDecorate();
	}
	private void beforeDecorate() {
		System.out.println("before decorate");
	}
	
	private void afterDecorate() {
		System.out.println("after decorate");
	}

}
