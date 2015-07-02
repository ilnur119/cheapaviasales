package org.teamyeah.cheapaviasales.db.entity;

import java.util.Calendar;

/**
 * Объектное представление сущности "Перелёт".
 */
public class Trip {

	/**
	 * id
	 */
	private Integer id;
	
	/**
	 * Дата отправления
	 */
	private Calendar departDate;
	
	/**
	 * Дата обратного вылета
	 */
	private Calendar returnDate;
	
	/**
	 * Пункт отправления
	 */
	private String origin;

	/**
	 * Пункт назначения
	 */
	private String destination;
	
	/**
	 * Отслеживать ли по достижению заданной цены
	 */
	private boolean targetPriceChecking;

	/**
	 * Отслеживать ли по относительному изменению цены
	 */
	private boolean diffPriceChecking;

	/**
	 * Заданная цена, о достижении которой нужно уведомлять 
	 */
	private Integer targetPrice;
	
	/**
	 * Заданное изменение цены, о котором нужно уведомлять 
	 */
	private Integer diffPrice;
	
	/**
	 * Последняя цена, о которой уведомлялся пользователь
	 */
	private Integer lastReportedPrice;
	
	/**
	 * Отправлять ли уведомление на эл. почту
	 */
	private boolean notifyToEmail;
	
	/**
	 * E-mail, на который нужно отправлять уведомления
	 */
	private String email;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getDepartDate() {
		return departDate;
	}

	public void setDepartDate(Calendar departDate) {
		this.departDate = departDate;
	}

	public Calendar getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Calendar returnDate) {
		this.returnDate = returnDate;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public boolean isTargetPriceChecking() {
		return targetPriceChecking;
	}

	public void setTargetPriceChecking(boolean targetPriceChecking) {
		this.targetPriceChecking = targetPriceChecking;
	}

	public boolean isDiffPriceChecking() {
		return diffPriceChecking;
	}

	public void setDiffPriceChecking(boolean diffPriceChecking) {
		this.diffPriceChecking = diffPriceChecking;
	}

	public Integer getTargetPrice() {
		return targetPrice;
	}

	public void setTargetPrice(Integer targetPrice) {
		this.targetPrice = targetPrice;
	}

	public Integer getDiffPrice() {
		return diffPrice;
	}

	public void setDiffPrice(Integer diffPrice) {
		this.diffPrice = diffPrice;
	}

	public Integer getLastReportedPrice() {
		return lastReportedPrice;
	}

	public void setLastReportedPrice(Integer lastReportedPrice) {
		this.lastReportedPrice = lastReportedPrice;
	}

	public boolean isNotifyToEmail() {
		return notifyToEmail;
	}

	public void setNotifyToEmail(boolean notifyToEmail) {
		this.notifyToEmail = notifyToEmail;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}