package com.example.demo.JavaPractice;

import java.time.LocalTime;

public class MyTask extends Thread {
	private String taskName;

	public MyTask(String taskName) {
		this.taskName = taskName;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(2 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Executing.... " + taskName + "in thread: " + Thread.currentThread().getName() + " at "
				+ LocalTime.now());
	}

}
