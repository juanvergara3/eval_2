package models;

import enums.ShipmentType;
import records.ShipmentData;

public class SeaShipment extends Shipment {

    public SeaShipment(ShipmentData shipmentData) {
        super(shipmentData);
    }

    @Override
    public double calculateCost() {
        return 800 + (super.getWeight() * 1000);
    }

    @Override
    public String[] getData() {
        return new String[]{
                ShipmentType.SEA.getLabel(),
                super.getCustomer(),
                super.getCode(),
                String.valueOf(super.getWeight()),
                String.valueOf(super.getDistance()),
                String.valueOf(calculateCost())
        };
    }
}
