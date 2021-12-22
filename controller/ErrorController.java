package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;
import javafx.fxml.FXML;
import model.*;

public class ErrorController extends Controller<InputException>{
   
    @FXML private Text errorTxt;
    
    
    public final Exception getException(){ return model; }
    
    
    @FXML public void initialize(){
        errorTxt.setText(getException().getMessage());
    }
    
    @FXML private void handleOkay(ActionEvent e) throws Exception{
        stage.close();
    }
    
    
}
