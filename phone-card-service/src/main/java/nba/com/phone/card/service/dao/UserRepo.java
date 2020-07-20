package nba.com.phone.card.service.dao.user;

import org.springframework.data.repository.CrudRepository;
import nba.com.phone.card.service.model.user.User;

public interface UserRepo extends CrudRepository<User, Integer>{
	public User findByUserName(String userName);
}
