package com.company.adapter;

/**
 * ����������  ----> ���ж���
 * @author YuanZhiWu
 *
 */
public class Wrapper implements Targetable{
	private Source mSource;
	public  Wrapper(Source soure) {
		// TODO Auto-generated constructor stub
		mSource = soure;
	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		this.mSource.method1();
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		
	}

}
