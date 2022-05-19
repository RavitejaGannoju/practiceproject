package com.example.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.entity.CowidCases;

@FeignClient(url = "https://coronavirus-19-api.herokuapp.com", name = "covid")
public interface CowidCasesFeign {
	
	
	@GetMapping(path = "/countries")
	public List<CowidCases> getCowidCases();

}
