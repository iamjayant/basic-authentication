package com.example.demo;

import java.time.LocalTime;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.JavaPractice.DaysEnum;
import com.example.demo.JavaPractice.MyTask;
import com.example.demo.JavaPractice.ThreadPoolExecuterDemo;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//enumDemo();
		//threadPoolExecuterDemo();
		
		
		SpringApplication.run(DemoApplication.class, args);
	}

	private static void enumDemo() {
		for(DaysEnum day : DaysEnum.values()) {
			day.printDesc();
		}
	} 

	private static void threadPoolExecuterDemo() {
		BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(5);
		ThreadPoolExecuterDemo threadPoolExecuterDemo = new ThreadPoolExecuterDemo(2, 3, 1, queue);
		
		ThreadFactory threadFactory = new ThreadFactory() {
			
			@Override
			public Thread newThread(Runnable r) {
				Thread thread = new Thread(r);
				thread.setPriority(Thread.NORM_PRIORITY);
				return thread;
			}
		};
		threadPoolExecuterDemo.setCustomThreadFactory(threadFactory);
		
		RejectedExecutionHandler rejectedExecutionHandler = new RejectedExecutionHandler() {
			
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				System.out.println("Task Rejected: " + r + ", pool size working: " + executor.getPoolSize());
			}
		};
		threadPoolExecuterDemo.setCustomRejectedExecutionHandler(rejectedExecutionHandler);
		
		
		for(int i=0; i<10; i++) {
			String task = "Task-"+i;
			System.out.println("Submitting task: " + task + " at " + LocalTime.now());
			
			threadPoolExecuterDemo.submitTask(new MyTask(task));
		}
		threadPoolExecuterDemo.startService();
	}
	
}
