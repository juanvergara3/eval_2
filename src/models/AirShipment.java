package models;

import records.ShipmentData;

public class AirShipment extends Shipment {

    public AirShipment(ShipmentData shipmentData) {
        super(shipmentData);
    }

    public double calculateCost() {
        return 5000 + (super.getWeight() * 4000);
    }
}
