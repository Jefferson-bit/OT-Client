package com.crash.resources.exceptions;

public class FieldMessage {

	private String field;
	private String messageError;

	public FieldMessage() {
	}

	public FieldMessage(String field, String messageError) {
		this.field = field;
		this.messageError = messageError;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}

}
