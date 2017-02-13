package com.neweducation.application.execute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.neweducation.application.config","com.neweducation.application.controllers"})
public class Application {
	
    @RequestMapping("/req")
    @ResponseBody
    String test() {
        return "AppWorks!";
    }

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
