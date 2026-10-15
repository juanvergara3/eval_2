package interfaces.mainView;

public interface IMainViewOutputs {

    // getter públicos para que el controlador pueda obtener los datos de la vista
    public String getCustomer();

    public String getCode();

    public String getWeight();

    public String getDistance();

    public String getShipmentType();

    public int getSelectedShipmentIndex();
}
