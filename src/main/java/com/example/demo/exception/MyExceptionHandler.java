package com.example.demo.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {
@ExceptionHandler(ArithmeticException.class)
public String exception(ArithmeticException exception) {
	return "sorry number cannot be divided by zero";
}

@ExceptionHandler(DataNotFoundException.class)
public String exceptions(DataNotFoundException dataNotFoundException) {
	return "Data not found";
}
}
