package interfaces.logisticsService;

import enums.ShipmentType;
import records.ShipmentData;

public interface ILogisticsServiceOperations {

    // métodos que se usan exclusivamente para realizar operaciones sobre los envíos.
    public String addShipment(ShipmentType type, ShipmentData shipmentData);

    public String removeShipmentByIndex(int index);

    public String removeShipmentByCode(String shipmentCode);
}
