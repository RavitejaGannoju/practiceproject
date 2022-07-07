package com.example;

import java.util.ArrayList;
import java.util.List;

public class Test {
	
	

	public static void main(String[] args) {
		
	  List<String> data = new ArrayList(); 
	  data.add("test"); 
	  data.add("test1");
	  data.forEach(System.out::println);
	  
	  for(String record : data) {
	  
	  }
	 
	}
	
}
