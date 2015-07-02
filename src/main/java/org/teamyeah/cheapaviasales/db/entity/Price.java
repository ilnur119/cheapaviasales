package org.teamyeah.cheapaviasales.db.entity;

import java.util.Calendar;

/**
 * Объектное представление сущности "Цена".
 */
public class Price {

	/**
	 * id
	 */
	private Integer id;

	/**
	 * Перелёт, к которому относится цена 
	 */
	private Trip trip;
	
	/**
	 * Цена в рублях
	 */
	private Integer price;
	
	/**
	 * Время запроса, когда была получена данная цена
	 */
	private Calendar priceTime;
	
	/**
	 * Количество пересадок
	 */
	private Integer changesCount;
	
	/**
	 * Авиакомпания - код IATA
	 */
	private String airline;
	
	/**
	 * Номер рейса
	 */
	private Integer flightNumber;
	
	/**
	 * Дата и время вылета
	 */
	private String departureAt;
	
	/**
	 * Дата и время обратного вылета
	 */
	private String returnAt;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Calendar getPriceTime() {
		return priceTime;
	}

	public void setPriceTime(Calendar priceTime) {
		this.priceTime = priceTime;
	}

	public Integer getChangesCount() {
		return changesCount;
	}

	public void setChangesCount(Integer changesCount) {
		this.changesCount = changesCount;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public Integer getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(Integer flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDepartureAt() {
		return departureAt;
	}

	public void setDepartureAt(String departureAt) {
		this.departureAt = departureAt;
	}

	public String getReturnAt() {
		return returnAt;
	}

	public void setReturnAt(String returnAt) {
		this.returnAt = returnAt;
	}


}