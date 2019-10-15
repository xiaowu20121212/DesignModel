package com.company.facade;

public class CPU implements IWork{

	@Override
	public void startUp() {
		// TODO Auto-generated method stub
		System.out.println("CPU startup");
	}

	@Override
	public void shutDown() {
		// TODO Auto-generated method stub
		System.out.println("CPU shutdown");
	}

}
