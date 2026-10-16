package factories;

import enums.ShipmentType;
import models.AirShipment;
import models.Shipment;
import records.ShipmentData;

public class AirFactory extends ShipmentFactory {
    @Override 
    public Shipment createShipment(ShipmentData data) {
        return new AirShipment(ShipmentType.AIR, data);
    }
}
