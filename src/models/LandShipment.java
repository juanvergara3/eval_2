package models;

import records.ShipmentData;

public class LandShipment extends Shipment {

    public LandShipment(ShipmentData shipmentData) {
        super(shipmentData);
    }

    @Override
    public double calculateCost() {
        return 1500 + (super.getWeight() * 2000);
    }
}
