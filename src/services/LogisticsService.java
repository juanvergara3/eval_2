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
        String[][] data = new String[shipments.size()][Headers.values().length];

        int column, row = 0;
        for(Shipment shipment : shipments) {
            column = 0;
            for(String value : shipment.getData()) {
                if(column < Headers.values().length)
                    data[row][column] = value;
                column++;
            }
            row++;
        }
        return data;
    }

    // Métodos públicos para agregar y eliminar envíos
    public static String addShipment(ShipmentType type, ShipmentData shipmentData) {
        String errorMessage = validateShipmentData(shipmentData);

        if (errorMessage != null)
            return errorMessage;
        
        Shipment shipment = null;
        shipment = ShipmentFactory.getFactory(type).createShipment(shipmentData);
        if (shipment != null) {
            shipments.add(shipment);
            return null;
        }

        // caso de failsafe por si falla algo en la fábrica.
        return "Error: No se pudo crear el envío.";
    }

    public static boolean removeShipment(int index) {
        //TODO implementar
        return false;
    }

    // métodos helper privados
    private static String validateShipmentData(ShipmentData shipmentData) {
        if (shipmentData.customer() == null || shipmentData.customer().isEmpty()) {
            return "Error: El nombre del cliente no puede estar vacío.";
        }
        if (shipmentData.code() == null || shipmentData.code().isEmpty()) {
            return "Error: El código del envío no puede estar vacío.";
        }
        if (shipmentData.weight() < 0) {
            return "Error: El peso del envío no puede ser negativo.";
        }
        if (shipmentData.distance() < 0) {
            return "Error: La distancia del envío no puede ser negativa.";
        }
        for (Shipment shipment : shipments) {
            if (shipment.getCode().equals(shipmentData.code())) {
                return "Error: Ya existe un envío con el mismo código.";
            }
        }
        return null;
    }
}
