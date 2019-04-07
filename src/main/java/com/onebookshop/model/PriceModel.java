package com.onebookshop.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PriceModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4544245634523845248L;
	
	private double basePrice;
	private double tax;
	private double discount;
	private double specialDiscount;


	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getSpecialDiscount() {
		return specialDiscount;
	}

	public void setSpecialDiscount(double specialDiscount) {
		this.specialDiscount = specialDiscount;
	}

}
