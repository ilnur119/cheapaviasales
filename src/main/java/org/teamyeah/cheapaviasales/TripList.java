package org.teamyeah.cheapaviasales;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class TripList extends AnchorPane {

    @FXML
    private Button addTripBtn;

    @FXML
    private ListView<TripModel> tripList;

    @FXML
    void addTrip(ActionEvent event) {
        trips.getValue().add(new TripModel());
    }

    ListProperty<TripModel> trips = new SimpleListProperty<>();

    public TripList() {
        super();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TripList.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException("Unable to load TripList control", e);
        }
    }

    @FXML
    protected void initialize() {
        tripList.itemsProperty().bindBidirectional(tripsProperty());
        tripList.setCellFactory(listView -> new ListCell<TripModel>() {
            TripBox tripBox = new TripBox();
            @Override
            protected void updateItem(TripModel item, boolean empty) {
                super.updateItem(item, empty);
                tripBox.setTrip(item);
                tripBox.setVisible(!empty);
                setText(null);
                setGraphic(tripBox);
            }
        });
        tripList.setFocusTraversable(false);
        tripList.setSelectionModel(new NoSelectionModel<>());
    }

    public ObservableList<TripModel> getTrips() {
        return trips.get();
    }

    public ListProperty<TripModel> tripsProperty() {
        return trips;
    }

    public void setTrips(ObservableList<TripModel> trips) {
        this.trips.set(trips);
    }

    private static class NoSelectionModel<T> extends MultipleSelectionModel<T> {
        @Override
        public ObservableList<Integer> getSelectedIndices() {
            return FXCollections.emptyObservableList();
        }

        @Override
        public ObservableList<T> getSelectedItems() {
            return FXCollections.emptyObservableList();
        }

        @Override
        public void selectIndices(int index, int... indices) { }

        @Override
        public void selectAll() { }

        @Override
        public void selectFirst() { }

        @Override
        public void selectLast() { }

        @Override
        public void clearAndSelect(int index) { }

        @Override
        public void select(int index) { }

        @Override
        public void select(Object obj) { }

        @Override
        public void clearSelection(int index) { }

        @Override
        public void clearSelection() { }

        @Override
        public boolean isSelected(int index) {
            return false;
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public void selectPrevious() { }

        @Override
        public void selectNext() { }
    }
}
