package org.teamyeah.cheapaviasales.db.dao;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.teamyeah.cheapaviasales.db.entity.Price;
import org.teamyeah.cheapaviasales.db.entity.Trip;

/** DAO объекта Price */
public interface PriceDao {

	/** Создает новую запись и соответствующий ей объект */
	public Price create() throws SQLException;

	/**
	 * Возвращает объект, соответствующий записи с первичным ключом key или null
	 */
	public Price read(int key) throws SQLException;

	/** Сохраняет состояние объекта в базе данных */
	public void update(Price price) throws SQLException;

	/** Удаляет запись об объекте из базы данных */
	public void delete(Price price) throws SQLException;

	/**
	 * Возвращает список объектов соответствующих всем записям в базе данных с
	 * заданным Trip
	 */
	public List<Price> getAllByTrip(Trip trip) throws SQLException;

	/** Сохраняет новый объект в базе данных */
	public Price persist(Price price) throws SQLException;

	/** Разбирает возвращённый ResultSet в список цен */
	public List<Price> parseResultSet(ResultSet rs) throws SQLException;

	/** Возвращает число строк в таблице */
	public int rowCount() throws SQLException;

}
