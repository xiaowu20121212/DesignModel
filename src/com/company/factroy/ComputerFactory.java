package com.company.factroy;

public class ComputerFactory implements Factroy<Computer> {

	public Computer product() {
		// TODO Auto-generated method stub
		return new Computer.Builder().setCore(4).setName("Apple").build();
	}

}
