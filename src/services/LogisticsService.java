package services;

import java.util.List;
import java.util.ArrayList;

import enums.Headers;
import enums.ShipmentType;
import models.*;
import records.ShipmentData;
import factories.ShipmentFactory;

public class LogisticsService {

    private static List<Shipment> shipments = new ArrayList<Shipment>();

    // getters públicos para uso con el controlador
    public static String[] getShipmentTypes() {
        String[] shipmentTypes = new String[ShipmentType.values().length];

        for(ShipmentType type : ShipmentType.values()) {
            shipmentTypes[type.ordinal()] = type.getLabel();
        }
        return shipmentTypes;
    }

    public static String[] getHeaders() {
        String[] headers = new String[Headers.values().length];

        for(Headers header : Headers.values()) {
            headers[header.ordinal()] = header.getLabel();
        }
        return headers;
    }

    public static String[][] getData() {
        //TODO implementar
        return new String[0][0];
    }

    public static boolean addShipment(ShipmentType type, ShipmentData shipmentData) {
        //TODO implementar
        // Aquí se van a poner las validaciones de datos del estilo de "el peso no puede ser negativo", etc.
        return false;
    }

    public static boolean removeShipment(int index) {
        //TODO implementar
        return false;
    }
}
