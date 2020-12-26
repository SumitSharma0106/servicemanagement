package com.learn.app.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotFoundResponse {
	
	private int status;
	private String message;
	private long timeStamp;

}
