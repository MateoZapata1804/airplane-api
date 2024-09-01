package co.com.airplane_api.exceptions;

import org.springframework.http.HttpStatus;

public class AirplaneException extends Exception {

	private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
	
    public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public AirplaneException() {
        super("Ocurrio un error logico");
    }
    
    public AirplaneException(String message, HttpStatus status) {
    	super(message);
    	this.httpStatus = status;
    }

    public AirplaneException(String message, HttpStatus status, Throwable ex) {
        super(message, ex);
        this.httpStatus = status;
    }
}
