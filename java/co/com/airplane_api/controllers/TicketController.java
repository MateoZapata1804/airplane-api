package co.com.airplane_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.airplane_api.exceptions.AirplaneException;
import co.com.airplane_api.models.TicketModel;
import co.com.airplane_api.models.http.RequestResponse;
import co.com.airplane_api.services.TicketService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("tickets")
public class TicketController {

	@Autowired
	TicketService ticketSvc;
	
	@ExceptionHandler(AirplaneException.class)
	public ResponseEntity<RequestResponse> handleException(AirplaneException ex) {
		
		var response = new RequestResponse(ex.toString(), ex.getHttpStatus(), ex.getMessage());
		
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@GetMapping("/getTickets")
	public ResponseEntity<RequestResponse> getTickets() throws AirplaneException {
		var result = ticketSvc.getTickets();
		
		return ResponseEntity.status(result.getStatus()).body(result);
	}
	
	@PostMapping("/addTicket")
	public ResponseEntity<RequestResponse> addTicket(@RequestBody TicketModel request) throws AirplaneException {
		var result = ticketSvc.addTicket(request);
		
		return ResponseEntity.status(result.getStatus()).body(result);
	}
	
}
