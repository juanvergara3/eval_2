package factories;

import enums.ShipmentType;
import models.Shipment;
import records.ShipmentData;

public abstract class ShipmentFactory {
    public abstract Shipment createShipment(ShipmentData data);

    public static ShipmentFactory getFactory(ShipmentType type) {
        return switch (type) {
            case ShipmentType.SEA -> new SeaFactory();
            case ShipmentType.LAND -> new LandFactory();
            case ShipmentType.AIR -> new AirFactory();
        };
    }

}
