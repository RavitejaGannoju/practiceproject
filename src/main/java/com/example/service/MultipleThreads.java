package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.stereotype.Component;

@Component
public class MultipleThreads {

	public void multithreadImplementation() {

		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
		List<Callable<String>> taskList = new ArrayList<>();
		
		try {
			
			for(int threadIndex=1 ; threadIndex <= 10; threadIndex++) {
				final String strThreadIndex = "Thread - "  + threadIndex;
				Callable<String> callable = () -> threadExecution(strThreadIndex);
				taskList.add(callable);
			}
			
			List<Future<String>> futures = newFixedThreadPool.invokeAll(taskList);
			
			for(Future<String> future : futures) {
				System.out.println(future.get());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			newFixedThreadPool.shutdown();
		}
	}
	
	public String threadExecution(String threadIndex) {
		
		for(int i=1 ; i <= 10; i++) {
			System.out.println(threadIndex + " Count - " + i); 
		}
		return "Sucessfully excuted";
	}
}
