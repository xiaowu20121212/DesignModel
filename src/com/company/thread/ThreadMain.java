package com.company.thread;

public class ThreadMain {
	public static final Object mLock = new Object();
	public static void main(String[] args) {
		MyThread1 thread1 = new MyThread1();
		MyThread1 thread2 = new MyThread1();
		MyThread1 thread3 = new MyThread1();
		thread1.start();
		thread2.start();
		thread3.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (mLock) {
			mLock.notifyAll();
		}
	}
	public static synchronized void runThread() {
		String name = Thread.currentThread().getName();
		System.out.println(name + "获取到Thread.class的锁");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name + "释放Thread.class的锁");
	}
		
	static class MyThread1 extends Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			runThread();
			waitThread();
		}
		public void waitThread() {
			String name = Thread.currentThread().getName();
				
				synchronized (mLock) {
					System.out.println(name + "释放mLock，进入等待---------------");
					try {
						mLock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(name + "被唤醒，获取mLock--------------------");
				}
		}
	}
}
