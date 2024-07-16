package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AdminService;

@RestController
@RequestMapping("/calci")
public class CalciController {
@Autowired
AdminService serv;


@GetMapping("add/{a}/{b}")
public String add(@PathVariable int a,@PathVariable int b){
	return "result is : "+(a+b);
	
}
@GetMapping("sub/{a}/{b}")
public String sum(@PathVariable int a,@PathVariable int b){
	return "result is : "+(a-b);
	
}
@GetMapping("mul/{a}/{b}")
public String mul(@PathVariable int a,@PathVariable int b){
	return "result is : "+(a*b);
	
}
@GetMapping("div/{a}/{b}")
public String div(@PathVariable double a,@PathVariable double b){
	return "result is : "+(a/b);
	
}
}
