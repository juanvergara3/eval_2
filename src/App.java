import controllers.MainController;
import views.MainView;

public class App {
    public static void main(String[] args) throws Exception {
        MainView mainView = new MainView();
        new MainController(mainView);
        mainView.setVisible(true);
    }
}
