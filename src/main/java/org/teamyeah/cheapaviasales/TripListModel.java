package org.teamyeah.cheapaviasales;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class TripListModel {

    private ListProperty<TripModel> tripModels;

    public TripListModel() {
        TripListModel model = this;
        tripModels = new SimpleListProperty<>();
        tripModels.addListener((ListChangeListener<TripModel>) c -> {
            while (c.next()) {
                if (c.wasAdded()) {
                    c.getAddedSubList().stream().forEach(item -> item.setModel(model));
                } else if (c.wasRemoved()) {
                    c.getRemoved().stream().forEach(item -> item.setModel(null));
                }
            }
        });
    }

    public ObservableList<TripModel> getTripModels() {
        return tripModels.get();
    }

    public ListProperty<TripModel> tripModelsProperty() {
        return tripModels;
    }

    public void setTripModels(ObservableList<TripModel> tripModels) {
        this.tripModels.set(tripModels);
    }
}
