package interfaces.mainView;

public interface IMainViewWindows {

    // métodos que el controlador puede usar mostrar diversos tipos de ventanas
    public boolean confirm(String message);

    public String askForInput(String message);

    public void showMessage(String message);
}
