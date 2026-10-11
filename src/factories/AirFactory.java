package factories;

import models.AirShipment;
import models.Shipment;
import records.ShipmentData;

public class AirFactory extends ShipmentFactory {
    @Override 
    public Shipment createShipment(ShipmentData data) {
        return new AirShipment(data);
    }
}
