package models;

import enums.ShipmentType;
import records.ShipmentData;

public class SeaShipment extends Shipment {

    public SeaShipment(ShipmentType type, ShipmentData shipmentData) {
        super(type, shipmentData);
    }

    @Override
    public double calculateCost() {
        return super.shipmentData.distance() * (800 + (super.shipmentData.weight() * 1000));
    }
}
