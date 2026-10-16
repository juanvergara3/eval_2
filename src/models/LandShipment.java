package models;

import enums.ShipmentType;
import records.ShipmentData;

public class LandShipment extends Shipment {

    public LandShipment(ShipmentType type, ShipmentData shipmentData) {
        super(type, shipmentData);
    }

    @Override
    public double calculateCost() {
        return super.shipmentData.distance() * (1500 + (super.shipmentData.weight() * 2000));
    }
}
