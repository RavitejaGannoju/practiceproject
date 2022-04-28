package com.example;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class PracticeprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeprojectApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localResolver() {
		AcceptHeaderLocaleResolver sessionLocaleResolver = new AcceptHeaderLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(Locale.US);
		return sessionLocaleResolver;
	}
	
	//	Configured in application.properties
	/*
	 * @Bean public ResourceBundleMessageSource bundleMessageSource() {
	 * ResourceBundleMessageSource bundleMessageSource = new
	 * ResourceBundleMessageSource(); bundleMessageSource.setBasename("message");
	 * return bundleMessageSource; }
	 */
}
