package com.learn.app.service;

public interface EmailService {
	
	public boolean sendEmail(String subject,String message,String to,String cc);

}
