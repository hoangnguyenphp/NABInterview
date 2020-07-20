package nba.com.phone.card.service.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CardPurchaseHistory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer cardPurchaseHistoryId;
	String userName;
	String voucherCode;
	LocalDate purchaseDate;
	
	public Integer getCardPurchaseHistoryId() {
		return cardPurchaseHistoryId;
	}
	public void setCardPurchaseHistoryId(Integer cardPurchaseHistoryId) {
		this.cardPurchaseHistoryId = cardPurchaseHistoryId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getVoucherCode() {
		return voucherCode;
	}
	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	

}
