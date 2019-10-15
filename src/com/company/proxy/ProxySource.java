package com.company.proxy;
/**
 * ������󣬳�����ʵ�ߣ�Ҳ����˵����Ĺ��ܱ������ʵ����ͬ�������޷���ɴ�����
 * @author YuanZhiWu
 *
 */
public class ProxySource implements ISourceable{
	private Source mSource;
	public  ProxySource() {
		// TODO Auto-generated constructor stub
		mSource = new Source();
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		mSource.show();
	}

}
