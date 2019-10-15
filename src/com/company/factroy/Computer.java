package com.company.factroy;

public class Computer implements IProduct {
	private int mCore;
	private String mName;
	
	@Override
	public String getProductName() {
		// TODO Auto-generated method stub
		return "Computer.class.getName()";
	}
	public  int getCore() {
		return mCore;
	}

	private void setCore(int mCore) {
		this.mCore = mCore;
	}

	public String getName() {
		return mName;
	}

	private void setName(String mName) {
		this.mName = mName;
	}
	/**
	 * ??????????
	 * @author YuanZhiWu
	 *
	 */
	public static class Builder{
		private Computer mComputer;
		public Builder(){
			mComputer = new Computer();
		}
		public Builder setCore(int core) {
			mComputer.setCore(core);
			return this;
		}
		public Builder setName(String name) {
			mComputer.setName(name);
			return this;
		}
		public Computer build(){
			return mComputer;
		}
	}
}
