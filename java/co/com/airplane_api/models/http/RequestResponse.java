package co.com.airplane_api.models.http;

import org.springframework.http.HttpStatus;

public class RequestResponse {
	
	private Object data;
	private HttpStatus status;
	private String message;
	
	public RequestResponse() {}
	
	public RequestResponse(Object data, HttpStatus status, String message) {
		this.data = data;
		this.status = status;
		this.message = message;
	}
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
