package org.teamyeah.cheapaviasales.db.entity;

import java.time.LocalDateTime;

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
	private LocalDateTime priceTime;
	
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
	private LocalDateTime departureAt;
	
	/**
	 * Дата и время обратного вылета
	 */
	private LocalDateTime returnAt;
	
	

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

	public LocalDateTime getPriceTime() {
		return priceTime;
	}

	public void setPriceTime(LocalDateTime priceTime) {
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

	public LocalDateTime getDepartureAt() {
		return departureAt;
	}

	public void setDepartureAt(LocalDateTime departureAt) {
		this.departureAt = departureAt;
	}

	public LocalDateTime getReturnAt() {
		return returnAt;
	}

	public void setReturnAt(LocalDateTime returnAt) {
		this.returnAt = returnAt;
	}


}