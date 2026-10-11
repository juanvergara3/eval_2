package controllers;

import views.MainView;
import enums.ShipmentType;
import records.ShipmentData;
import services.LogisticsService;

public class MainController {

    private MainView mainView;

    public MainController(MainView mainView) {
        this.mainView = mainView;

        // se intectan métodos para agregar y quitar envíos sin que la vista tenga información de la implementación del controlador
        this.mainView.setAddShipmentClick(event -> addShipment());
        this.mainView.setRemoveShipmentClick(event -> removeShipment());

        populateShipmentTypes();
        showShipments();
    }

    public void populateShipmentTypes() {
        mainView.populateShipmentTypeComboBox(LogisticsService.getShipmentTypes());
    }

    public void showShipments() {
        mainView.showShipments(LogisticsService.getHeaders(), LogisticsService.getData());
    }

    private void addShipment() {
        ShipmentType shipmentType;
        String customer, code;
        Double weight, distance;

        // Se hace un try-catch para capturar cualquier error de conversión de tipos de datos
        try {
            shipmentType = ShipmentType.fromLabel(mainView.getShipmentType());
            customer = mainView.getCustomer();
            code = mainView.getCode();
            weight = Double.parseDouble(mainView.getWeight());
            distance = Double.parseDouble(mainView.getDistance());
        } catch (Exception ex) {
            mainView.showMessage("Error: Hubo un problema al convertir tipos de datos. Por favor, verifique que los datos ingresados sean correctos.");

            return;
        }
        
        boolean shipmentAdded = LogisticsService.addShipment(shipmentType, new ShipmentData(customer, code, weight, distance));

        if (shipmentAdded) {
            showShipments();
            mainView.clearShipmentFields();
            mainView.hideShipmentEdit();
        } else {
            mainView.showMessage("El envío no pudo ser agregado");
        }
    }

    private void removeShipment() {
        //TODO implementar
    }
}
