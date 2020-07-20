package nba.com.phone.card.service.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import nba.com.phone.card.service.model.CardPurchaseHistory;

public interface CardPurchaseHistoryRepo extends CrudRepository<CardPurchaseHistory, Integer>{	
	public List<CardPurchaseHistory> findByUserNameOrderByCardPurchaseHistoryIdDesc(String userName);
}
