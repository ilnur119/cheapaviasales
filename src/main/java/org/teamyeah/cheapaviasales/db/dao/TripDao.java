package org.teamyeah.cheapaviasales.db.dao;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.teamyeah.cheapaviasales.db.entity.Trip;

/** DAO объекта Trip */
public interface TripDao {

	/** Создает новую запись и соответствующий ей объект */
	public Trip create() throws SQLException;

	/** Возвращает объект, соответствующий записи с первичным ключом key или null */
	public Trip read(int key) throws SQLException;

	/** Сохраняет состояние объекта в базе данных */
	public void update(Trip trip) throws SQLException;

	/** Удаляет запись об объекте из базы данных */
	public void delete(Trip trip) throws SQLException;

	/** Возвращает список объектов соответствующих всем записям в базе данных */
	public List<Trip> getAll() throws SQLException;
	
	/** Сохраняет новый объект в базе данных */
	public Trip persist(Trip trip) throws SQLException;

	/** Разбирает возвращённый ResultSet в список перелётов */
	public List<Trip> parseResultSet(ResultSet rs) throws SQLException;

	/** Возвращает число строк в таблице */
	public int rowCount() throws SQLException;

}
