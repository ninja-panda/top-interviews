package com.google.tree;

public class DaemonT extends Thread {


	public void run() {
		System.out.println("I am Running Thread : " + Thread.currentThread().getName());
	}

	public DaemonT(String name) {
		super(name);
	}


	public static void main(String[] args) {
		DaemonT t1 = new DaemonT("t1");
		DaemonT t2 = new DaemonT("t2");
		t1.start();
		t1.setDaemon(true);
		t2.start();
	}
}
