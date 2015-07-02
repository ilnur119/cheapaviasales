package org.teamyeah.cheapaviasales.entity;

import javafx.beans.property.*;
import javafx.collections.ObservableList;
import org.teamyeah.cheapaviasales.db.dao.TripDao;

import java.time.LocalDate;

public class Trip {

    private StringProperty origin = new SimpleStringProperty();
    private StringProperty destination = new SimpleStringProperty();
    private ObjectProperty<LocalDate> departureDate = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDate> returnDate = new SimpleObjectProperty<>();

    private ObjectProperty<Settings> settings = new SimpleObjectProperty<>();
    private ListProperty<Price> history = new SimpleListProperty<>();

    public Trip(org.teamyeah.cheapaviasales.db.entity.Trip storedTrip, TripDao tripDao) {
        // Сохраняем объекты БД, при изменении себя сохраняем изменения и в БД.
    }

    public LocalDate getDepartureDate() {
        return departureDate.get();
    }

    public ObjectProperty<LocalDate> departureDateProperty() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate.set(departureDate);
    }

    public String getDestination() {
        return destination.get();
    }

    public StringProperty destinationProperty() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination.set(destination);
    }

    public ObservableList<Price> getHistory() {
        return history.get();
    }

    public ListProperty<Price> historyProperty() {
        return history;
    }

    public void setHistory(ObservableList<Price> history) {
        this.history.set(history);
    }

    public String getOrigin() {
        return origin.get();
    }

    public StringProperty originProperty() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin.set(origin);
    }

    public LocalDate getReturnDate() {
        return returnDate.get();
    }

    public ObjectProperty<LocalDate> returnDateProperty() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate.set(returnDate);
    }

    public Settings getSettings() {
        return settings.get();
    }

    public ObjectProperty<Settings> settingsProperty() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings.set(settings);
    }
}
