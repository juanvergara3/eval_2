package interfaces;

import enums.ShipmentType;
import records.ShipmentData;

// se implementa una interfaz para hacer que el controlador no dependa de la implementación concreta del servicio, sino de la interfaz, lo que permite cambiar la implementación del servicio sin afectar al controlador
public interface ILogisticsService {

    public String[] getShipmentTypes();

    public String[] getHeaders();

    public String[][] getShipmentsTableDate();

    public String addShipment(ShipmentType type, ShipmentData shipmentData);

    public String removeShipmentByIndex(int index);

    public String removeShipmentByCode(String shipmentCode);
}
