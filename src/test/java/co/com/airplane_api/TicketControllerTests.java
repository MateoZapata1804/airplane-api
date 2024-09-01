package co.com.airplane_api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import co.com.airplane_api.controllers.TicketController;
import co.com.airplane_api.exceptions.AirplaneException;
import co.com.airplane_api.services.TicketService;

@SpringBootTest
class TicketControllerTests {

	@Mock
	private TicketService ticketSvcTest;
	
	@InjectMocks
	private TicketController ticketControllerTest;
	
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(TicketController.class);
	}
	
	@Test
	public void getTicketsHandleExceptionTest() {
		
		try {
			 
			when(ticketSvcTest.getTickets()).thenThrow(new AirplaneException());
			
			AirplaneException result = assertThrows(AirplaneException.class, () -> ticketControllerTest.getTickets());
			
			assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getHttpStatus());
			
		} catch (AirplaneException e) {
			fail(e);
		}
	}
	
}
