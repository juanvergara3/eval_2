package models;

import enums.ShipmentType;
import records.ShipmentData;

public class LandShipment extends Shipment {

    public LandShipment(ShipmentData shipmentData) {
        super(shipmentData);
    }

    @Override
    public double calculateCost() {
        return 1500 + (super.getWeight() * 2000);
    }

    @Override
    public String[] getData() {
        return new String[]{
                ShipmentType.AIR.getLabel(),
                super.getCustomer(),
                super.getCode(),
                String.valueOf(super.getWeight()),
                String.valueOf(super.getDistance()),
                String.valueOf(calculateCost())
        };
    }
}
