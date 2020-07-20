package nba.com.phone.card.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import nba.com.phone.card.service.dao.cardpurchasehistory.CardPurchaseHistoryRepo;
import nba.com.phone.card.service.dao.user.UserRepo;
import nba.com.phone.card.service.model.cardpurchasehistory.CardPurchaseHistory;

@RestController
public class PhoneCardServiceController {
	
	@Autowired
	CardPurchaseHistoryRepo cardPurchaseHistoryRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@RequestMapping("/card-purchase-history/{userName}")
	public List<CardPurchaseHistory> getCardPurchaseHistoryByUser(@PathVariable(name="userName") String userName) {
		if(userRepo.findByUserName(userName) != null) {
			List<CardPurchaseHistory> listCardPurchaseHistory = cardPurchaseHistoryRepo.findByUserName(userName);
			if( listCardPurchaseHistory != null && listCardPurchaseHistory.size() > 0) {
				return listCardPurchaseHistory;
			} else {
		         throw new ResponseStatusException(
		                 HttpStatus.NOT_FOUND, "You have not buy any card yet.");
			}
		} else {
	         throw new ResponseStatusException(
	                 HttpStatus.UNPROCESSABLE_ENTITY, "User " + userName + " is invalid.");
		}
	}
}
