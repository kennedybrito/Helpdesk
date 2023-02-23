package com.helpdesk.resource.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandarError {
	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValidationError(Long timestamp, Integer status, String erros, String message, String path) {
		super(timestamp, status, erros, message, path);
		// TODO Auto-generated constructor stub
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String message) {
		this.errors.add(new FieldMessage(fieldName, message));
	}
	
	
	
	
	
	

}
