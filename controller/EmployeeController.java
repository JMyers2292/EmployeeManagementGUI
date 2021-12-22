package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.util.LinkedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.*;


public class EmployeeController extends Controller<Employee> {
    @FXML private Button addBtn;
    @FXML private Button updateBtn;
    @FXML private Button closeBtn;
    
    @FXML private TextField nameTf;
    @FXML private TextField emailTf;
    @FXML private TextField phoneTf;
    @FXML private TextField addressTf;
    @FXML private TextField tfnTf;
    @FXML private TextField paidHoursTf;
    @FXML private TextField HourlyRateTf;
    @FXML private TextField jobTypeTf;
    
    

    private String getNameTf() {return nameTf.getText();}
    private void setNameTf(String name) {nameTf.setText(name);}
    
    private String getEmailTf() {return emailTf.getText();}
    private void setEmailTf(String email) {emailTf.setText(email);}

    private String getPhoneTf() {return phoneTf.getText();}
    private void setPhoneTf(String number) {phoneTf.setText(number);}
    
    private String getAddressTf() {return addressTf.getText();}
    private void setAddressTf(String address) {addressTf.setText(address);}
    
    private String getTfnTf() {return tfnTf.getText();}
    private void setTfnTf(String tfn) {tfnTf.setText(tfn);}
    
    private int getPaidHoursTf() {return Integer.parseInt(paidHoursTf.getText());}
    private void setPaidHoursTf(int hours) {paidHoursTf.setText(""+ hours);}

    private double getHourlyRateTf() {return Double.parseDouble(HourlyRateTf.getText());}
    private void setHourlyRateTf(double rate) {HourlyRateTf.setText(""+rate);}

    private String getJobTypeTf() {return jobTypeTf.getText();}
    private void setJobTypeTf(String type) {jobTypeTf.setText(type);}
    
    public final Employee getEmployee(){ return model; }
    
    @FXML public void initialize(){
        Employee employee = getEmployee();
        if(employee.getName().equals("") && employee.getEmail().equals("") 
            && employee.getPhone().equals("") && employee.getAddress().equals("")
            && employee.getTFN().equals("") && employee.getType().equals("")){
            updateBtn.setDisable(true);
            addBtn.setDisable(false);
            setPaidHoursTf(0);
            setHourlyRateTf(0.0);
        }
        else{
            addBtn.setDisable(true);
            updateBtn.setDisable(false);
            setNameTf(employee.getName());
            setEmailTf(employee.getEmail());
            setPhoneTf(employee.getPhone());
            setAddressTf(employee.getAddress());
            setTfnTf(employee.getTFN());
            setPaidHoursTf(employee.getHours());
            setHourlyRateTf(employee.getPayPerHour());
            setJobTypeTf(employee.getType());
        }
        
    }
    
    @FXML private void handleAdd(ActionEvent e) throws Exception{
        Validator validator = new Validator();
        LinkedList<String> errors = validator.errors();
        try{
            validator.clear();
            if(!validator.isValid(getNameTf(),getEmailTf(), getPhoneTf(),
                    getAddressTf(), getJobTypeTf(), getTfnTf(), getPaidHoursTf(),
                    getHourlyRateTf())){
                
                validator.generateErrors(getNameTf(),getEmailTf(), getPhoneTf(),
                getAddressTf(), getJobTypeTf(), getTfnTf(), getPaidHoursTf(),
                getHourlyRateTf());
                throw new InputException(errorMessage(errors));
            }
            else{
                getEmployee().updateDetails(getNameTf(), getEmailTf(), getPhoneTf(), 
                    getAddressTf(), getTfnTf(), getJobTypeTf(),
                    getPaidHoursTf() , getHourlyRateTf());
                stage.close();

            }          
        }catch(InputException exception){
            Stage newStage = new Stage();
            Image errorIcon = new Image(getClass().getResourceAsStream("/view/error.png"));
            newStage.getIcons().add(errorIcon);
            newStage.setX(750);
            newStage.setY(200);
            ViewLoader.showStage(exception, "/view/error.fxml", "Input Exceptions", newStage);
        }
    }
    
    @FXML private void handleUpdate(ActionEvent e) throws Exception{
        Validator validator = new Validator();
        LinkedList<String> errors = validator.errors();
        try{    
            validator.clear();
            if(!validator.isValid(getNameTf(),getEmailTf(), getPhoneTf(),
                        getAddressTf(), getJobTypeTf(), getTfnTf(), getPaidHoursTf(),
                        getHourlyRateTf())){
                validator.generateErrors(getNameTf(),getEmailTf(), getPhoneTf(),
                        getAddressTf(), getJobTypeTf(), getTfnTf(), getPaidHoursTf(),
                        getHourlyRateTf());
                throw new InputException(errorMessage(errors));
            }
            else{
                getEmployee().updateDetails(getNameTf(), getEmailTf(), getPhoneTf(),
                    getAddressTf(), getTfnTf(), getJobTypeTf(),
                    getPaidHoursTf(), getHourlyRateTf());
                stage.close();
            }
        }catch(InputException exception){
            Stage newStage = new Stage();
            Image errorIcon = new Image(getClass().getResourceAsStream("/view/error.png"));
            newStage.getIcons().add(errorIcon);
            newStage.setX(750);
            newStage.setY(200);
            ViewLoader.showStage(exception, "/view/error.fxml", "Input Exceptions", newStage);
        }
    }
    
    @FXML private void handleClose(ActionEvent e) throws Exception{
        stage.close();
    }
    
    private String errorMessage(LinkedList<String> errors){
        String errMsg = String.join("", errors);
        return errMsg;
    }

}