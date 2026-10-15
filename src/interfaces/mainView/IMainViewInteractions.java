package interfaces.mainView;

public interface IMainViewInteractions {

    // métodos de interacción con la vista
    public void populateShipmentTypeComboBox(String[] shipmentTypes);

    public void showShipments(String [] headers, String[][] shipmentTableData);

    public void hideShipmentEdit();
}
