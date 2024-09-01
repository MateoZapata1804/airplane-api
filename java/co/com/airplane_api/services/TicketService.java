package co.com.airplane_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import co.com.airplane_api.exceptions.AirplaneException;
import co.com.airplane_api.models.FlightModel;
import co.com.airplane_api.models.TicketModel;
import co.com.airplane_api.models.http.RequestResponse;
import co.com.airplane_api.repositories.FlightRepository;
import co.com.airplane_api.repositories.TicketRepository;

@Service
public class TicketService {

	@Autowired
	TicketRepository ticketRepo;
	@Autowired
	FlightRepository flightRepo;
	
	public RequestResponse getTickets() throws AirplaneException {
		
		try {
			
			var result = ticketRepo.findAll();
			
			return new RequestResponse(result, HttpStatus.OK, "Consulta realizada con exito!");
			
		} catch (Exception e) {
			throw new AirplaneException("Ocurrio un error inesperado", HttpStatus.INTERNAL_SERVER_ERROR, e);
		}
		
	}
	
	public RequestResponse addTicket(TicketModel ticket) throws AirplaneException {
		
		var flightResult = flightRepo.findById(ticket.getFlightId());
		
		if (flightResult.isEmpty())
			throw new AirplaneException("El vuelo especificado no existe", HttpStatus.BAD_REQUEST);
		
		var result = ticketRepo.save(ticket);
		
		return new RequestResponse(result, HttpStatus.OK, "Registro guardado exitosamente");
		
	}
	
}
