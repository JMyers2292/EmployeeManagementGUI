package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.*;




public class LoginController extends Controller<Employers>{
    @FXML private Button loginBtn;
    @FXML private Button cancelBtn;
    @FXML private Label errorLbl;
    @FXML private TextField emailTF;
    @FXML private PasswordField passwordTF;
    private Employers employers;
    
            
    public final Employers getEmployers() { return model; }
    
    
    @FXML public void initialize(){
//         setMasterLogin("john.smith@uts.com", "super123");
         errorLbl.setText("");
    }
    
    private String getEmailText(){ return emailTF.getText(); }
    private void setEmailtText(String str){ emailTF.setText(str);}
    
    private String getPasswordText(){ return passwordTF.getText(); }
    private void setPasswordtText(String str){ passwordTF.setText(str);}
    
    private void setMasterLogin(String user, String password){ 
        setEmailtText(user);
        setPasswordtText(password);
    }
    
    @FXML private void handleUserLogin(ActionEvent e) throws Exception{
        //Need to get the model to get access to the data
        employers = getEmployers();
        if(employers.hasEmployer(getEmailText(), getPasswordText())){
            //Close login stage
            Employer match = employers.getEmployer(getEmailText(), getPasswordText());
            stage.close();
            //Open new stage which will show a ListView of employees
            Stage newStage = new Stage();
            Image calIcon = new Image(getClass().getResourceAsStream("/view/employer.png"));
            newStage.getIcons().add(calIcon);
            newStage.setX(10);
            newStage.setY(350);
            ViewLoader.showStage(match, "/view/employer.fxml",
                    "Session Admin: " + match.getName(), newStage);
            
        }
        else{                    
            errorLbl.setText("Incorrect login details");
            setEmailtText("");
            setPasswordtText("");
        }
    }
    
    @FXML private void handleCancel(ActionEvent e) throws Exception{
        stage.close();
    }    
}
