package nba.com.phone.card.service.dao;

import org.springframework.data.repository.CrudRepository;

import nba.com.phone.card.service.model.User;

public interface UserRepo extends CrudRepository<User, Integer>{
	public User findByUserName(String userName);
}
