package com.tabcorp.bms.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class BMSDetails implements Serializable {
	
    @Id
    @GeneratedValue
	private Long betId;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	@JsonProperty("DateTime")
	private LocalDateTime createdDate;
	@JsonProperty("BetType")
	private String betType;
	@JsonProperty("PropNumber")
	private Long propNumber;
	@JsonProperty("CustomerID")
	private Long customerId;
	@JsonProperty("Investment")
	private double investment;
	
	public Long getBetId() {
		return betId;
	}
	public void setBetId(Long betId) {
		this.betId = betId;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}	
	public String getBetType() {
		return betType;
	}
	public void setBetType(String betType) {
		this.betType = betType;
	}
	public Long getPropNumber() {
		return propNumber;
	}
	public void setPropNumber(Long propNumber) {
		this.propNumber = propNumber;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public double getInvestment() {
		return investment;
	}
	public void setInvestment(double investment) {
		this.investment = investment;
	}
	@Override
	public String toString() {
		return "BetDetails [betId=" + betId + ", createdDate=" + createdDate + ", betType=" + betType + ", propNumber="
				+ propNumber + ", customerId=" + customerId + ", investment=" + investment + "]";
	}	

}
