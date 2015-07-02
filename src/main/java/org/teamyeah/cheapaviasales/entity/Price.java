package org.teamyeah.cheapaviasales.entity;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDateTime;

public class Price {
    private ObjectProperty<LocalDateTime> time = new SimpleObjectProperty<>();
    private ObjectProperty<Integer> price = new SimpleObjectProperty<>();

    public Integer getPrice() {
        return price.get();
    }

    public ObjectProperty<Integer> priceProperty() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price.set(price);
    }

    public LocalDateTime getTime() {
        return time.get();
    }

    public ObjectProperty<LocalDateTime> timeProperty() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time.set(time);
    }
}
