package com.company.facade;

public class Memory implements IWork{

	@Override
	public void startUp() {
		// TODO Auto-generated method stub
		System.out.println("Memory startup");
	}

	@Override
	public void shutDown() {
		// TODO Auto-generated method stub
		System.out.println("memory shutdown");
	}

}
