package nba.com.phone.card.service.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import nba.com.phone.card.service.dao.CardPurchaseHistoryRepo;
import nba.com.phone.card.service.dao.UserRepo;
import nba.com.phone.card.service.model.CardPurchaseHistory;
import nba.com.phone.card.service.model.Voucher;

@RestController
public class PhoneCardServiceController {
	
	@Autowired
	CardPurchaseHistoryRepo cardPurchaseHistoryRepo;
	
	@Autowired
	UserRepo userRepo;
	
	static final String VIETTEL_VOUCHER_PURCHASE_API="http://localhost:8091/viettel-voucher-purchase";
	
	@RequestMapping("/viettel-voucher-purchase")
	public String purchaseViettelVoucher() {
		RestTemplate restTemplate = new RestTemplate();
		Voucher voucher = restTemplate.getForObject(VIETTEL_VOUCHER_PURCHASE_API, Voucher.class);
		CardPurchaseHistory cardPurchaseHistory = new CardPurchaseHistory();
		cardPurchaseHistory.setPurchaseDate(LocalDate.now());
		cardPurchaseHistory.setUserName("user1");
		cardPurchaseHistory.setVoucherCode(voucher.getVoucherCode());
		cardPurchaseHistoryRepo.save(cardPurchaseHistory);
		return voucher.getVoucherCode();		
	}
	
	
	@RequestMapping("/card-purchase-history/{userName}")
	public List<CardPurchaseHistory> getCardPurchaseHistoryByUser(@PathVariable(name="userName") String userName) {
		if(userRepo.findByUserName(userName) != null) {
			List<CardPurchaseHistory> listCardPurchaseHistory = cardPurchaseHistoryRepo.findByUserNameOrderByCardPurchaseHistoryIdDesc(userName);
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
