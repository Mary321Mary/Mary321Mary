package spring.dto;

public class NotValidError {

	private String field;
	private String message;
	
	public NotValidError() {
		this.field = "";
		this.message = "";
	}
	
	public NotValidError(String field, String message) {
		this.field = field;
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
