package models;

import enums.ShipmentType;
import records.ShipmentData;

public abstract class Shipment {

    protected final ShipmentData shipmentData;
    private final ShipmentType type;

    public Shipment(ShipmentType type, ShipmentData shipmentData) {
        this.type = type;
        this.shipmentData = shipmentData;
    }

    // métodos comunes a todas las clases hijas

    // este es el único getter público necesario, se usa en el servicio para comparar el código de envío que ingresó el usuario con los códigos de los envíos que hay en las lista de envíos; así se determina si el envío existe o no, y se borra el envío si existe.
    public String getCode() {
        return shipmentData.code();
    }

    public String[] getData() {
        return new String[]{
                this.type.getLabel(),
                this.shipmentData.code(),
                this.shipmentData.customer(),
                String.valueOf(this.shipmentData.weight()),
                String.valueOf(this.shipmentData.distance()),
                String.valueOf(calculateCost())
        };
    }

    // métodos abstractos que deben ser implementados por las clases hijas
    public abstract double calculateCost();
}
