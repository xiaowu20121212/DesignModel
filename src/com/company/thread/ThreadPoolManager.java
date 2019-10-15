package com.company.thread;

import java.util.Vector;

public class ThreadPoolManager {
	private int maxNum;
	private static final int DEFAULT_SIZE=20;
	private Vector<WorkThread> vector;
	private static ThreadPoolManager poolManager=null;
	
	private ThreadPoolManager() {
		init(DEFAULT_SIZE);
	}
	
	public  synchronized static ThreadPoolManager getInstance(){
		if(poolManager==null){
			poolManager=new ThreadPoolManager();
		}
		return poolManager;
	}
	
	public void init(int maxNum){
		if(maxNum<=0){
			this.maxNum=DEFAULT_SIZE;
		}else{
			this.maxNum=maxNum;
		}
		vector=new Vector<WorkThread>();
	}
	
	public void startup(String threadName){
			for(int i=0;i<maxNum;i++){
				WorkThread work=new WorkThread(this,threadName,i);
				vector.add(work);
				synchronized (this) {
					try {
						work.start();
						//这里wait来保证线程启动，等待线程来唤醒
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
						Thread.currentThread().interrupt();
					}
				}
			}
	}
	
	public synchronized void assigned(BaseTask task){
		while(true){
			for(int i=0;i<vector.size();i++){
				WorkThread work=vector.get(i);
				if(work.isAvailable()){
					work.assign(task);
					return; 
				}
			}
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}
	}
	public void stop(){
		for(int i=0;i<vector.size();i++){
			WorkThread work=vector.get(i);
			work.shutdown();
		}
	}

	public synchronized int getMaxNum() {
		return maxNum;
	}	
}
