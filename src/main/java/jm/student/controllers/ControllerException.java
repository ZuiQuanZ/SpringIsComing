package jm.student.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerException {
	@ExceptionHandler(Exception.class)
	public String handle() {
		return "/error";
	}
}
