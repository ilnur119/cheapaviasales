package org.teamyeah.cheapaviasales.entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Settings {

    private ObjectProperty<Integer> targetPrice = new SimpleObjectProperty<>();
    private ObjectProperty<Integer> diffPrice = new SimpleObjectProperty<>();
    private IntegerProperty lastReportedPrice = new SimpleIntegerProperty();

    public Integer getDiffPrice() {
        return diffPrice.get();
    }

    public ObjectProperty<Integer> diffPriceProperty() {
        return diffPrice;
    }

    public void setDiffPrice(Integer diffPrice) {
        this.diffPrice.set(diffPrice);
    }

    public int getLastReportedPrice() {
        return lastReportedPrice.get();
    }

    public IntegerProperty lastReportedPriceProperty() {
        return lastReportedPrice;
    }

    public void setLastReportedPrice(int lastReportedPrice) {
        this.lastReportedPrice.set(lastReportedPrice);
    }

    public Integer getTargetPrice() {
        return targetPrice.get();
    }

    public ObjectProperty<Integer> targetPriceProperty() {
        return targetPrice;
    }

    public void setTargetPrice(Integer targetPrice) {
        this.targetPrice.set(targetPrice);
    }
}
