package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.CowidCases;
import com.example.feignclient.CowidCasesFeign;

@RestController
@RequestMapping("demo")
public class DemoController {
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	CowidCasesFeign feign;

	@GetMapping("hello")
	public String helloWorld() {
		return "Hello world";
	}
	
	//Using Path Variables
	@GetMapping("/hello/{pathVariable}")
	public String getPathVariable(@PathVariable("pathVariable") String pathVariable) {
		return "Path varible : "+pathVariable;
	}
	
	@GetMapping("/internationalization-message")
	public String helloInternational() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());

	}
	
	@GetMapping("/cowid-cases")
	public List<CowidCases> getCowidReport() {
		return feign.getCowidCases();

	}
	
}
