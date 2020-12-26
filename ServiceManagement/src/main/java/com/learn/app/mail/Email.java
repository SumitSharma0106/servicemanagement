package com.learn.app.mail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Email {

	private String to;
	private String cc;
	private String subject;
	private String message;

}
