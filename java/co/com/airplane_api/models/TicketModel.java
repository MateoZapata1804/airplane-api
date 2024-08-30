package co.com.airplane_api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tickets")
public class TicketModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	@Column(name = "user_id", unique = true, nullable = false)
	private Long userId;
	@Column(name = "flight_id", unique = true, nullable = false)
	private Long flightId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getFlightId() {
		return flightId;
	}
	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}
}
