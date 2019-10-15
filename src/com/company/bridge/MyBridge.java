package com.company.bridge;

public class MyBridge implements ISourceable{
	private ISourceable mSource;
	@Override
	public void doWork() {
		// TODO Auto-generated method stub
		mSource.doWork();
	}
	public void setSource(ISourceable source) {
		this.mSource = source;
	}

}
