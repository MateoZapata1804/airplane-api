package co.com.airplane_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
	public RequestResponse handleException(AirplaneException ex) {
		return new RequestResponse(ex.toString(), false, ex.getMessage());
	}
	
	@GetMapping("/getTickets")
	public RequestResponse getTickets() throws AirplaneException {
		return ticketSvc.getTickets();
	}
	
	@PostMapping("/addTicket")
	public RequestResponse addTicket(@RequestBody TicketModel request) throws AirplaneException {
		return ticketSvc.addTicket(request);
	}
	
}
