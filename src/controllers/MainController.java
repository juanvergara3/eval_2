package controllers;

import views.MainView;
import enums.ShipmentType;
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
        //TODO implementar
    }

    private void removeShipment() {
        //TODO implementar
    }
}
