package factories;

import models.SeaShipment;
import models.Shipment;
import records.ShipmentData;

public class SeaFactory extends ShipmentFactory {
    @Override 
    public Shipment createShipment(ShipmentData data) {
        return new SeaShipment(data);
    }
}
