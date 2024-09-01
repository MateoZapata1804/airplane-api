package co.com.airplane_api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import co.com.airplane_api.exceptions.AirplaneException;
import co.com.airplane_api.models.TicketModel;
import co.com.airplane_api.models.http.RequestResponse;
import co.com.airplane_api.repositories.FlightRepository;
import co.com.airplane_api.repositories.TicketRepository;
import co.com.airplane_api.services.TicketService;

@SpringBootTest
class TicketsTests {

	@Mock
	private TicketRepository ticketRepoTest;
	@Mock
	private FlightRepository flightRepoTest;
	
	@InjectMocks
	private TicketService ticketSvcTest;
	
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(TicketService.class);
	}

	@Test
	public void getTicketsTest() {
		
		try {
			 
			when(ticketRepoTest.findAll()).thenReturn(new ArrayList<TicketModel>());
			
			var result = ticketSvcTest.getTickets();
			
			assertEquals(HttpStatus.OK, result.getStatus());
			assertTrue((Iterable<TicketModel>) result.getData() instanceof Iterable<TicketModel>);
			 
		} catch (AirplaneException e) {
			fail(e);
		}
	}
	
	@Test
	public void getTicketsHandleExceptionTest() {
		
		try {
			 
			when(ticketRepoTest.findAll()).thenThrow();
			
			assertThrows(AirplaneException.class, () -> ticketSvcTest.getTickets());
			 
		} catch (Exception e) {
			fail(e);
		}
	}
	
	@Test
	public void addTicketWithoutExistingFlightTest() {
		
		try {
			Long ticketId = 0L, flightId = 0L, userId = 0L;
			
			TicketModel testModel = new TicketModel();
			testModel.setId(ticketId);
			testModel.setFlightId(flightId);
			testModel.setUserId(userId);
			
			when(flightRepoTest.findById(ticketId)).thenReturn(Optional.empty());
			
			var ex = assertThrows(AirplaneException.class, () -> ticketSvcTest.addTicket(testModel));
			assertEquals(HttpStatus.BAD_REQUEST, ex.getHttpStatus());
			 
		} catch (Exception e) {
			fail(e);
		}
	}
}
