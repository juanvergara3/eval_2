package controllers;

import views.MainView;
import services.LogisticsService;

public class MainController {

    private MainView mainView;

    public MainController(MainView mainView) {
        this.mainView = mainView;

        // se intectan métodos para agregar y quitar envíos sin que la vista tenga información de la implementación del controlador
        this.mainView.setAddShipmentClick(event -> addShipment());
        this.mainView.setRemoveShipmentClick(event -> removeShipment());

       showShipments();
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
