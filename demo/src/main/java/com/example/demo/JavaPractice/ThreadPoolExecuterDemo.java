package com.example.demo.JavaPractice;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecuterDemo {
	
	private ThreadPoolExecutor executor;
	
	public ThreadPoolExecuterDemo(int corePoolSize, int maxPoolSize, int keepAliveTimeInMinutes, BlockingQueue<Runnable> queue) {
		executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTimeInMinutes, TimeUnit.MINUTES, queue);
	}
	
	public void submitTask(Runnable task) {
		executor.submit(task);
	}
	
	public void setDaemon(boolean setDaemon) {
		//executor.
	}
	
	public void setCustomThreadFactory(ThreadFactory threadFactory) {
		executor.setThreadFactory(threadFactory);
	}
	
	public void setCustomRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler) {
		executor.setRejectedExecutionHandler(rejectedExecutionHandler);
	}
	
	public void startService() {
		executor.shutdown();
	}
}
