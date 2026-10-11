package services;

import java.util.List;
import java.util.ArrayList;

import enums.Headers;
import models.*;
import records.ShipmentData;
import factories.ShipmentFactory;

public class LogisticsService {

    private static List<Shipment> shipments = new ArrayList<Shipment>();


    // getters públicos para uso con el controlador
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

    public static Shipment addShipment(ShipmentData shipmentData) {
        //TODO implementar
        return null;
    }

    public static boolean removeShipment(int index) {
        //TODO implementar
        return false;
    }
}
