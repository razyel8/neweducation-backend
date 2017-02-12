package com.neweducation.application.controllers;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController {
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> testGet(@RequestParam(value = "authToken") String authToken,
			@RequestParam(value = "testName") String testName){
		return ResponseEntity.ok().body(String.format("Witaj %s o tokenie %s", testName, authToken));
	}
	
	@RequestMapping(value = "/testme", method = RequestMethod.GET)
	@ResponseBody
	public String testGet2(){
		return "App works!";
	}

}
