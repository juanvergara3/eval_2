package interfaces;

import java.awt.event.ActionListener;

// se crea una interfaz con todos los métodos que el controlador necesita para interactuar con la vista. Esto permite que el controlador no dependa de la implementación concreta de la vista, sino de una abstracción.
public interface IMainView {

    // métodos de interacción con la vista
    public void populateShipmentTypeComboBox(String[] shipmentTypes);

    public void showShipments(String [] headers, String[][] shipmentTableData);

    public void showMessage(String message);

    public void hideShipmentEdit();

    public boolean confirm(String message);

    public String askForInput(String message);

    // setters para inyección de dependencias
    public void setAddShipmentClick(ActionListener listener);

    public void setRemoveShipmentClick(ActionListener listener);

    // getter públicos para que el controlador pueda obtener los datos de la vista
    public String getCustomer();

    public String getCode();

    public String getWeight();

    public String getDistance();

    public String getShipmentType();

    public int getSelectedShipmentIndex();
}
