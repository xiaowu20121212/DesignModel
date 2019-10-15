package com.company.facade;

public class Disk implements IWork{

	@Override
	public void startUp() {
		// TODO Auto-generated method stub
		System.out.println("Disk startup");
	}

	@Override
	public void shutDown() {
		// TODO Auto-generated method stub
		System.out.println("Disk shutdown");
	}

}
