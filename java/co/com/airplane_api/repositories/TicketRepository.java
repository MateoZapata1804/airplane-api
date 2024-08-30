package co.com.airplane_api.repositories;

import org.springframework.data.repository.CrudRepository;

import co.com.airplane_api.models.TicketModel;

public interface TicketRepository extends CrudRepository<TicketModel, Long> {

}
