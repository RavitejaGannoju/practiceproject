package com.example.entity;

import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {
	
	private int userId;
	
	@Size(min = 2, message = "User name should be minimum 2 characters")
	private String userName;
	
	//private Date dob;
	
	

}
