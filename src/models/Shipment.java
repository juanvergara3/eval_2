package models;

import records.ShipmentData;

public abstract class Shipment {

    private ShipmentData shipmentData;

    public Shipment(ShipmentData shipmentData) {
        this.shipmentData = shipmentData;
    }

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

    public abstract double calculateCost();
}
