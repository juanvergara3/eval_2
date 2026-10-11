package factories;

import models.LandShipment;
import models.Shipment;
import records.ShipmentData;

public class LandFactory extends ShipmentFactory {

    @Override 
    public Shipment createShipment(ShipmentData data) {
        return new LandShipment(data);
    }
}
