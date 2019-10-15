package com.company.thread;

/**
 * @author Administrator
 *
 */
public class WorkThread extends Thread {
	
	private static final int WorKThread_IDLE=0;
	private static final int WorKThread_BUSY=1;
	private boolean running;
	private boolean assigned;
	private ThreadPoolManager poolManager;
	private BaseTask task;
	private int state;
	
	public WorkThread(ThreadPoolManager poolManager,String name,int i) {
		super(name+" "+i);
		this.poolManager=poolManager;
		
		assigned=false;
		running=false;
		state=WorKThread_IDLE;
	}
	
	@Override
	public synchronized void run() {
		running=true;
		synchronized (poolManager) {
			poolManager.notify();
			//释放poolManager的锁
		}
		while(running){
			if(assigned){
				state=WorKThread_BUSY;
				task.execute();
				synchronized (poolManager) {
					assigned=false;
					state=WorKThread_IDLE;
					task=null;
					poolManager.notify();
					notify();
				}
			}
			try {
				//如果没有任务，进入等待，由assing方法唤醒
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}
	}
	
	public boolean isAvailable(){
		return (!assigned)&&running;
	}

	public synchronized void assign(BaseTask task){
		if(!running){
			//throw new RuntimeException("该线程没有运行");
			System.out.println("该线程没有运行");
			return;
		}
		
		if(assigned){
			//throw new RuntimeException("该线程已分配任务了");
			System.out.println("该线程已分配任务了");
			return;
		}
		
		this.task=task;
		assigned=true;
		//唤醒自己去执行任务
		notify();
	}
	

	public synchronized void shutdown(){
		if(!running){
			throw new RuntimeException("该线程没有运行");
		}
		if(assigned){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}
		running=false;
		notify();
	}

	public int getStates() {
		return state;
	}

}
