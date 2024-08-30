package co.com.airplane_api.repositories;

import org.springframework.data.repository.CrudRepository;

import co.com.airplane_api.models.TicketModel;
import co.com.airplane_api.models.UserModel;

public interface UserRepository extends CrudRepository<UserModel, Long> {

}
