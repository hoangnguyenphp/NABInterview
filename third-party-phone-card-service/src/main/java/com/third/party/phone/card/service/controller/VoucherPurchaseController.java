package com.third.party.phone.card.service.controller;

import java.security.SecureRandom;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.third.party.phone.card.service.model.Voucher;

@RestController
public class VoucherPurchaseController {	
	static final String AB = "0123456789";
	static SecureRandom rnd = new SecureRandom();
	
	@RequestMapping("/viettel-voucher-purchase")
	public Voucher buyVoucher() {
		Voucher voucher = new Voucher();
		voucher.setVoucherCode(randomString(16));
		voucher.setIsUsed(false);		
		return voucher;
	}

	private String randomString( int len ){
	   StringBuilder sb = new StringBuilder( len );
	   for( int i = 0; i < len; i++ ) 
	      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
	   return sb.toString();
	}

}
