package org.teamyeah.cheapaviasales;

import javafx.beans.property.*;

import java.time.LocalDate;

/**
 * Represents a trip with given origin, destination, departure date.
 */
public class TripModel {
    private StringProperty origin = new SimpleStringProperty();
    private StringProperty destination = new SimpleStringProperty();
    private ObjectProperty<LocalDate> departureDate = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDate> returnDate = new SimpleObjectProperty<>();
    private TripListModel model;

    private IntegerProperty currentPrice = new SimpleIntegerProperty();

    public TripModel() {
        this("", "", LocalDate.now(), null, 0);
    }

    public TripModel(String origin, String destination, LocalDate departureDate, LocalDate returnDate, int currentPrice) {
        this.origin.setValue(origin);
        this.destination.setValue(destination);
        this.departureDate.setValue(departureDate);
        this.returnDate.setValue(returnDate);
        this.currentPrice.setValue(currentPrice);
    }

    public int getCurrentPrice() {
        return currentPrice.get();
    }

    public IntegerProperty currentPriceProperty() {
        return currentPrice;
    }

    public void setCurrentPrice(int currentPrice) {
        this.currentPrice.set(currentPrice);
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

    public TripListModel getModel() {
        return model;
    }

    public void setModel(TripListModel model) {
        this.model = model;
    }
}
