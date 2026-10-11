package models;

import enums.ShipmentType;
import records.ShipmentData;

public class AirShipment extends Shipment {

    public AirShipment(ShipmentData shipmentData) {
        super(shipmentData);
    }

    @Override
    public double calculateCost() {
        return 5000 + (super.getWeight() * 4000);
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
