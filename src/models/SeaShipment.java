package models;

import records.ShipmentData;

public class SeaShipment extends Shipment {

    public SeaShipment(ShipmentData shipmentData) {
        super(shipmentData);
    }

    @Override
    public double calculateCost() {
        return 800 + (super.getWeight() * 1000);
    }
}
