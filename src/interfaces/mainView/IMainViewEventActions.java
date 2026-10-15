package interfaces.mainView;

import java.awt.event.ActionListener;

public interface IMainViewEventActions {

    // setters para inyección de dependencias
    public void setAddShipmentClick(ActionListener listener);

    public void setRemoveShipmentClick(ActionListener listener);
}
