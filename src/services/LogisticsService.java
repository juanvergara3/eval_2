package services;

import java.util.List;
import java.util.ArrayList;

import enums.Headers;
import enums.ShipmentType;
import models.*;
import records.ShipmentData;
import factories.ShipmentFactory;

public class LogisticsService {

    private final List<Shipment> shipments;

    public LogisticsService() {
        this.shipments = new ArrayList<Shipment>();
    }

    // getters públicos para uso con el controlador
    public String[] getShipmentTypes() {
        String[] shipmentTypes = new String[ShipmentType.values().length];

        for(ShipmentType type : ShipmentType.values()) {
            shipmentTypes[type.ordinal()] = type.getLabel();
        }
        return shipmentTypes;
    }

    public String[] getHeaders() {
        String[] headers = new String[Headers.values().length];

        for(Headers header : Headers.values()) {
            headers[header.ordinal()] = header.getLabel();
        }
        return headers;
    }

    public String[][] getData() {
        String[][] shipmentData = new String[shipments.size()][Headers.values().length];

        int column, row = 0;
        for(Shipment shipment : shipments) {
            column = 0;
            for(String value : shipment.getData()) {
                if(column < Headers.values().length)
                    shipmentData[row][column] = value;
                column++;
            }
            row++;
        }
        return shipmentData;
    }

    // Métodos públicos para agregar y eliminar envíos
    public String addShipment(ShipmentType type, ShipmentData shipmentData) {
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

    public String removeShipmentByIndex(int index) {
        if (index >= 0 && index < shipments.size()) {
            shipments.remove(index);
            return null;
        }
        return "Error: No se pudo eliminar el envío.";
    }

    public String removeShipmentByCode(String code) {
        for (int i = 0; i < shipments.size(); i++) {
            if (shipments.get(i).getCode().equals(code)) {
                shipments.remove(i);
                return null;
            }
        }
        return "Error: No se encontró un envío con el código proporcionado.";
    }

    // métodos helper privados
    private String validateShipmentData(ShipmentData shipmentData) {
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
