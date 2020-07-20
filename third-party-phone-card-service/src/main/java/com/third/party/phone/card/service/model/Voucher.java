package com.third.party.phone.card.service.model;

public class Voucher {
	private String publisher = "Viettel";
	private String voucherCode;
	private boolean isUsed;
	
	public String getPublisher() {
		return publisher;
	}
	public String getVoucherCode() {
		return voucherCode;
	}
	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}
	public boolean getIsUsed() {
		return isUsed;
	}
	public void setIsUsed(boolean used) {
		this.isUsed = used;
	}
}
