package models;

import enums.ShipmentType;
import records.ShipmentData;

public abstract class Shipment {

    private ShipmentData shipmentData;

    public Shipment(ShipmentData shipmentData) {
        this.shipmentData = shipmentData;
    }

    // métodos comunes a todas las clases hijas
    public String getCustomer() {
        return shipmentData.customer();
    }

    public String getCode() {
        return shipmentData.code();
    }

    public double getWeight() {
        return shipmentData.weight();
    }

    public double getDistance() {
        return shipmentData.distance();
    }

    public String[] getData() {
        return new String[]{
                getType().getLabel(),
                getCode(),
                getCustomer(),
                String.valueOf(getWeight()),
                String.valueOf(getDistance()),
                String.valueOf(calculateCost())
        };
    }

    // métodos abstractos que deben ser implementados por las clases hijas
    public abstract double calculateCost();

    public abstract ShipmentType getType();
}
