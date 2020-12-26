package com.learn.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.app.mail.Email;
import com.learn.app.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {
	
	@Autowired
	EmailService emailService;
	
	@PostMapping
	public ResponseEntity<?> sendEmail(@RequestBody Email email){
		System.out.println(email);
		this.emailService.sendEmail(email.getSubject(), email.getMessage(), email.getTo(), email.getCc());
		return ResponseEntity.ok("Done ...");
	}

}
