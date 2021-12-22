package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.application.Platform;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import model.*;


public class SessionController extends Controller<Session>{
   @FXML private GridPane layoutGP;
   @FXML private Button loginBtn;
   @FXML private Button exitBtn;
   
   
   private Line newLine = new Line(0,400,500,400);
   
   

    public void initialize(){
        newLine.setStroke(Color.WHITE);
        
    }
    public final Session getSession(){ return model;}
    
    @FXML private void handleLogin(ActionEvent e) throws Exception{
        //Create new stage
        Stage newStage = new Stage();
        Image bookIcon = new Image(getClass().getResourceAsStream("/view/book.png"));
        newStage.getIcons().add(bookIcon);
        //Show new Login screen
        newStage.setX(100);
        newStage.setY(200);
        ViewLoader.showStage(new Employers(), "/view/login.fxml", "Sign in", newStage);
        
    }
    
    @FXML private void handleExit(ActionEvent e) throws Exception{
        Platform.exit();
    }

}
