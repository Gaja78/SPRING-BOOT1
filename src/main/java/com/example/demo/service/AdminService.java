package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


import com.example.demo.entity.Admin;
import com.example.demo.exception.DataNotFoundException;
import com.example.demo.repository.AdminRepository;
@Component
public class AdminService {
@Autowired
AdminRepository repository ;

public ResponseEntity<String> saveadmin(Admin admin){
	repository.save(admin);
	return new ResponseEntity<String>("data saved sucess",HttpStatus.CREATED);
}

public ResponseEntity<String> saveadminAll(List<Admin> admins) {
	repository.saveAll(admins);
	return new ResponseEntity<String>("data saved sucess",HttpStatus.CREATED);
}

public ResponseEntity<Admin> fetchById(int id) {
	Admin admins=repository.findById(id).orElseThrow(()->new DataNotFoundException("no data found in this id : "+id));
	return new ResponseEntity<Admin>(admins,HttpStatus.FOUND);
}

public ResponseEntity<String> fetchAll() throws DataNotFoundException {
	List<Admin> admins=repository.findAll();
	if(admins.isEmpty()) {
		throw new DataNotFoundException("data not found");
	}
	else {
		return new ResponseEntity<String>("data fetched sucessfully",HttpStatus.FOUND);

	}
}

public ResponseEntity<List<Admin>> findByEmail(String email) {
	List<Admin> emails=repository.findByEmail(email);
	if(emails.isEmpty()) {
		throw new DataNotFoundException("invalid email : "+email);
	}
	else {
		return new ResponseEntity<List<Admin>>(emails,HttpStatus.FOUND);

	}
}

public ResponseEntity<String> DeleteById(int id) throws DataNotFoundException {
	Admin admin=repository.findById(id).orElseThrow(()-> new DataNotFoundException("data not found in this id : "+id));
	repository.delete(admin);
	return new ResponseEntity<String>("data deleted sucessfully",HttpStatus.FOUND);
}

public ResponseEntity<String> login(String email, String password) {
	List<Admin> admins=repository.findByEmailAndPassword(email,password);
	if(admins.isEmpty()) {
		return new ResponseEntity<String>("login failed",HttpStatus.NOT_FOUND);
	}else {
		return new ResponseEntity<String>("login sucess",HttpStatus.FOUND);
	}
}

public ResponseEntity<String> updateAdmin(Admin admin) {
if(admin != null && admin.getEmail() != null) {
	repository.save(admin);
	return new ResponseEntity<>("data updated sucessfully",HttpStatus.OK);

}
else {
	throw new DataNotFoundException("Invalid Data");
}
}



}
