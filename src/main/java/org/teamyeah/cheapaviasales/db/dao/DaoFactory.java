package org.teamyeah.cheapaviasales.db.dao;

import java.sql.Connection;
import java.sql.SQLException;

/** Фабрика объектов для работы с базой данных */
public interface DaoFactory {

	/** Возвращает подключение к базе данных */
	public Connection getConnection() throws SQLException;

	/** Возвращает объект для управления персистентным состоянием объекта Trip */
	public TripDao getTripDao(Connection connection);

	/** Возвращает объект для управления персистентным состоянием объекта Price */
	public PriceDao getPriceDao(Connection connection);
}
