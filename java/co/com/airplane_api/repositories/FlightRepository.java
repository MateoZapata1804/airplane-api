package co.com.airplane_api.repositories;

import org.springframework.data.repository.CrudRepository;

import co.com.airplane_api.models.FlightModel;

public interface FlightRepository extends CrudRepository<FlightModel, Long> {

}
