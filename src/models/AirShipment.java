package models;

import enums.ShipmentType;
import records.ShipmentData;

public class AirShipment extends Shipment {

    public AirShipment(ShipmentType type, ShipmentData shipmentData) {
        super(type, shipmentData);
    }

    @Override
    public double calculateCost() {
        return super.shipmentData.distance() * (5000 + (super.shipmentData.weight() * 4000));
    }    
}
