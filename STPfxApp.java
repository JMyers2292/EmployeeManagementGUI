import au.edu.uts.ap.javafx.*;
import javafx.stage.*;
import javafx.application.Application;
import javafx.scene.image.Image;
import model.*;

public class STPfxApp extends Application {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Image icon = new Image(getClass().getResourceAsStream("view/book.png"));
        stage.getIcons().add(icon);
        stage.setX(10);
        stage.setY(100);
        ViewLoader.showStage(new Session(), "/view/session.fxml", "STPFX - Employer Mode", stage);
    }
}