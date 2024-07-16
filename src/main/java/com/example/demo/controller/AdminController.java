package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;


@RestController
@RequestMapping("/admins")
public class AdminController {
@Autowired
AdminService service;

@PostMapping	
public ResponseEntity<String> createAdmin(@RequestBody Admin admin){
	return service.saveadmin(admin);
	
}

@PostMapping("/many")
public ResponseEntity<String> saveadminAll(@RequestBody List<Admin> admins){
	return service.saveadminAll(admins);
	
}
@GetMapping("/{id}")
public ResponseEntity<Admin> fetchbyid(@PathVariable int id){
	return service.fetchById(id);
	
}
@GetMapping("/multiple")
public ResponseEntity<String> fetchAdmin(){
	return service.fetchAll();
}

//@PutMapping
//public ResponseEntity<String> updateAdmin(){
//	return null;
//	
//}
@DeleteMapping("/{id}")
public ResponseEntity<String> deleteAdminById(@PathVariable int id){
	return service.DeleteById(id);
	
}
 @GetMapping("/email/{email}")
public ResponseEntity<List<Admin>> findemail(@PathVariable String email){
	return service.findByEmail(email);
	
}
 @GetMapping("login/{email}/{password}")
 public ResponseEntity<String> login(@PathVariable String email,@PathVariable String password){
	return service.login(email,password);
	 
 }
 
@PutMapping
public ResponseEntity<String> updateAdmin(@RequestBody Admin admin){
	return service.updateAdmin(admin);
}
}
