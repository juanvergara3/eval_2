import controllers.MainController;
import services.LogisticsService;
import views.MainView;

public class App {
    public static void main(String[] args) throws Exception {
        MainView mainView = new MainView();
        LogisticsService logisticsService = new LogisticsService();
        new MainController(mainView, logisticsService);
        mainView.setVisible(true);
    }
}
