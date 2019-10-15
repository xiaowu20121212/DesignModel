package com.company.facade;
/**
 * ������ģʽ��ʵ���Ǹ�������壨������Ե������ڣ�
 * @author YuanZhiWu
 *
 */
public class Computer implements IWork{
	private CPU mCPU;
	private Memory mMemory;
	private Disk mDisk;
	public Computer() {
		mCPU = new CPU();
		mMemory = new Memory();
		mDisk = new Disk();
	}

	@Override
	public void startUp() {
		// TODO Auto-generated method stub
		System.out.println("Computer startup");
		mCPU.startUp();
		mMemory.startUp();
		mDisk.startUp();
	}

	@Override
	public void shutDown() {
		// TODO Auto-generated method stub
		System.out.println("Computer shutdown");
		mCPU.shutDown();
		mMemory.shutDown();
		mDisk.shutDown();
	}

}
