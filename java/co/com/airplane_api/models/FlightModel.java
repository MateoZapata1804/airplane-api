package co.com.airplane_api.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "flights")
public class FlightModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	
	@Column(name = "destiny", unique = true, nullable = false, length = 30)
	private String destiny;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "flight_date", unique = true, nullable = false)
	private Date flightDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDestiny() {
		return destiny;
	}
	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}
	public Date getFlightDate() {
		return flightDate;
	}
	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}
	
	
}
