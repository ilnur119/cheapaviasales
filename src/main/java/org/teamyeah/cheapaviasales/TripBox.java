package org.teamyeah.cheapaviasales;

import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class TripBox extends VBox {

    @FXML
    private Button historyBtn;

    @FXML
    private DatePicker returnDate;

    @FXML
    private TextField originField;

    @FXML
    private Button removeBtn;

    @FXML
    private DatePicker departureDate;

    @FXML
    private Button settingsBtn;

    @FXML
    private TextField destinationField;

    @FXML
    private TextField currentPriceField;

    @FXML
    private void showHistory(ActionEvent event) {

    }

    @FXML
    private void showSettings(ActionEvent event) {

    }

    @FXML
    private void remove(ActionEvent event) {
        TripModel trip = getTrip();
        if (trip != null && trip.getModel() != null) {
            trip.getModel().getTripModels().remove(trip);
        }
    }

    private ObjectProperty<TripModel> trip;
    private IntegerProperty currentPriceProperty = new SimpleIntegerProperty();

    public TripBox() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TripBox.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException("Unable to load TripBox control", e);
        }

        trip = new SimpleObjectProperty<>(null);
        trip.addListener((observable, oldValue, newValue) -> {
            if (oldValue != null) {
                originField.textProperty().unbindBidirectional(oldValue.originProperty());
                destinationField.textProperty().unbindBidirectional(oldValue.destinationProperty());
                departureDate.valueProperty().unbindBidirectional(oldValue.departureDateProperty());
                returnDate.valueProperty().unbindBidirectional(oldValue.returnDateProperty());
                currentPriceProperty.unbind();
            }

            if (newValue != null) {
                originField.textProperty().bindBidirectional(newValue.originProperty());
                destinationField.textProperty().bindBidirectional(newValue.destinationProperty());
                departureDate.valueProperty().bindBidirectional(newValue.departureDateProperty());
                returnDate.valueProperty().bindBidirectional(newValue.returnDateProperty());
                currentPriceProperty.bind(newValue.currentPriceProperty());
            }
        });
    }

    @FXML
    public void initialize() {
        currentPriceField.textProperty().bind(Bindings.convert(currentPriceProperty));
    }

    public TripModel getTrip() {
        return trip.get();
    }

    public ObjectProperty<TripModel> tripProperty() {
        return trip;
    }

    public void setTrip(TripModel trip) {
        this.trip.set(trip);
    }
}
