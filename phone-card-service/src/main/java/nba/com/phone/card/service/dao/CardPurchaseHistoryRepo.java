package nba.com.phone.card.service.dao.cardpurchasehistory;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import nba.com.phone.card.service.model.cardpurchasehistory.CardPurchaseHistory;

public interface CardPurchaseHistoryRepo extends CrudRepository<CardPurchaseHistory, Integer>{	
	public List<CardPurchaseHistory> findByUserName(String userName);
}
