package controllers;

import enums.ShipmentType;
import interfaces.ILogisticsService;
import interfaces.IMainView;
import records.ShipmentData;

public class MainController {

    private IMainView mainView;
    private ILogisticsService logisticsService;

    public MainController(IMainView mainView, ILogisticsService logisticsService) {
        this.mainView = mainView;
        this.logisticsService = logisticsService;

        // se intectan métodos para agregar y quitar envíos sin que la vista tenga información de la implementación del controlador
        this.mainView.setAddShipmentClick(event -> addShipment());
        this.mainView.setRemoveShipmentClick(event -> removeShipment());

        populateShipmentTypes();
        showShipments();
    }

    public void populateShipmentTypes() {
        mainView.populateShipmentTypeComboBox(logisticsService.getShipmentTypes());
    }

    public void showShipments() {
        mainView.showShipments(logisticsService.getHeaders(), logisticsService.getShipmentsTableDate());
    }

    private void addShipment() {
        ShipmentType shipmentType;
        Double weight, distance;

        // estas conversiones no pueden fallar, la validación de si están vacíos o no se hace en la vista primero y también en el servicio, junto con validaciones adicionaels
        String customer = mainView.getCustomer();
        String code= mainView.getCode();

        // Se hacen un try-catch para capturar cualquier error de conversión de tipos de datos
        // el controlador no se preocupa de que los datos sean correctos, es decir, no mira si el peso es no negativo, o si el código ya existe
        // solo se encarga de pasarle al servicio datos en el formato correcto.

        // este caso no debería fallar nunca, pero se pone por si las dudas, ya que el método fromLabel lanza una excepción si no encuentra el tipo de envío con el label que se le pase.
        try {
            shipmentType = ShipmentType.fromLabel(mainView.getShipmentType());
        } catch (Exception e) {
            mainView.showMessage("Error interno: Hubo un problema al procesar la selección del tipo de envío.");
            return;
        }

        try {
            weight = Double.parseDouble(mainView.getWeight());
        } catch (Exception e) {
            mainView.showMessage("Error: Revisar que el peso ingresado sea un número.");
            return;
        }

        try {
            distance = Double.parseDouble(mainView.getDistance());
        } catch (Exception e) {
            mainView.showMessage("Error: Revisar que la distancia ingresada sea un número.");
            return;
        }
        
        String shipmentAddStatus = logisticsService.addShipment(shipmentType, new ShipmentData(customer, code, weight, distance));

        if (shipmentAddStatus == null) {
            showShipments();
            mainView.hideShipmentEdit();
        } else {
            mainView.showMessage(shipmentAddStatus);
        }
    }

    private void removeShipment() {
        int selectedIndex = mainView.getSelectedShipmentIndex();
        String code = null;

        // -1 es el valor por defecto que Java el da al índice si no hay nada seleccionado.
        if(selectedIndex == -1)
            code = mainView.askForInput("Ingrese el código del envío a retirar:");

        if (mainView.confirm("¿Está seguro de retirar el envío?")) {
            String removeStatus = code == null ? logisticsService.removeShipmentByIndex(selectedIndex) : logisticsService.removeShipmentByCode(code.strip());
            if (removeStatus == null)
                showShipments();
            else 
                mainView.showMessage(removeStatus);
        }
    }
}
