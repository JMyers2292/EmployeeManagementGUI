package controller;


import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.util.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.InputEvent;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.*;


public class EmployerController extends Controller<Employer> {
    @FXML private TextField nameTF;
    @FXML private TextField emailTF;
    @FXML private Button addBtn;
    @FXML private Button deleteBtn;
    @FXML private Button selectBtn;
    @FXML private Button paygBtn;
    @FXML private Button stpBtn;
    @FXML private Button closeBtn;
    @FXML private TableView<Employee> employeeTv;
    @FXML private TableColumn<Employee, String> nameClm;
    @FXML private TableColumn<Employee, String> emailClm;
    @FXML private TableColumn<Employee, String> phoneClm;
    
    
    
    public final Employer getEmployer() { return model; }
    
    private String getNameTf(){ return nameTF.getText();}
    private String getEmailTf(){ return emailTF.getText();}
        
    @FXML public void initialize(){
        nameTF.setText("Filter by name");
        emailTF.setText("Filter by email");
        nameTF.textProperty().addListener((o, oldText, newText) -> getEmployer().filterList(nameTF.getText(), nameTF.getText()));
        //Trigger buttons to be enabled when employee selected
        employeeTv.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldEmployee, newEmployee) ->
            deleteBtn.setDisable(newEmployee == null));
        employeeTv.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldEmployee, newEmployee) ->
            paygBtn.setDisable(newEmployee == null));
        employeeTv.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldEmployee, newEmployee) ->
            selectBtn.setDisable(newEmployee == null));
        
        //Give Table data
        nameClm.setCellValueFactory(cellData -> 
                cellData.getValue().nameProperty());
        emailClm.setCellValueFactory(cellData -> 
                cellData.getValue().emailProperty());
        phoneClm.setCellValueFactory(cellData -> 
                cellData.getValue().phoneProperty());
        
        nameTF.textProperty().addListener((o, oldText, newText) -> getEmployer().filterList(nameTF.getText(), nameTF.getText()));       
        emailTF.textProperty().addListener((o, oldText, newText) -> getEmployer().filterList(emailTF.getText(), emailTF.getText()));
               
    }
        
    private Employee getSelectedEmployee(){ 
        return employeeTv.getSelectionModel().getSelectedItem(); 
    }

    
    @FXML private void handleAdd(ActionEvent e)throws Exception{
        try{    
            Stage newStage = new Stage();
            Image penIcon = new Image(getClass().getResourceAsStream("/view/edit.png"));
            newStage.getIcons().add(penIcon);
            Employee newEmployee = new Employee("", "", "", "", "", "", 0, 0);
            getEmployer().addEmployee(newEmployee);
            newStage.setX(710);
            newStage.setY(100);
            ViewLoader.showStage(newEmployee, "/view/employee.fxml",
                    "Adding New Employee", newStage);
            
        }catch(Exception event){
//            System.out.println("Something went wrong");
        }
        finally{
            deleteBtn.setDisable(true);
            selectBtn.setDisable(true);
            paygBtn.setDisable(true);
        }
    }
    
    @FXML private void handleDelete(ActionEvent e)throws Exception{
        try{
            getEmployer().removeEmployee(getSelectedEmployee());
        }catch(Exception event){}
        finally{
            deleteBtn.setDisable(true);
            selectBtn.setDisable(true);
            paygBtn.setDisable(true);
        }
    }
    
    @FXML private void handleSelect(ActionEvent e)throws Exception{
        try{
            Employee currentEmployee = getSelectedEmployee();
            Stage newStage = new Stage();
            Image penIcon = new Image(getClass().getResourceAsStream("/view/edit.png"));
            newStage.getIcons().add(penIcon);
            newStage.setX(710);
            newStage.setY(100);
            ViewLoader.showStage(currentEmployee, "/view/employee.fxml",
                    "Acessing File: " + getSelectedEmployee().getName(), newStage);
        }catch(Exception event){}
        finally{
            deleteBtn.setDisable(true);
            selectBtn.setDisable(true);
            paygBtn.setDisable(true);
        }
    }
    
    @FXML private void handlePAYG(ActionEvent e)throws Exception{        
        try{
            String name = getSelectedEmployee().getName();
            Stage newStage = new Stage();
            Image penIcon = new Image(getClass().getResourceAsStream("/view/edit.png"));
            newStage.getIcons().add(penIcon);
            newStage.setX(710);
            newStage.setY(350);
            ViewLoader.showStage(getSelectedEmployee(), "/view/payg.fxml", 
                    name + " PAYG Report", newStage);
        }catch(Exception event){ 
//                System.out.println("Something went wrong");
        }
        finally{
            deleteBtn.setDisable(true);
            selectBtn.setDisable(true);
            paygBtn.setDisable(true);
        }
    }
    
    @FXML private void handleSTP(ActionEvent e)throws Exception{
        try{
            Stage newStage = new Stage();
            Image stpIcon = new Image(getClass().getResourceAsStream("/view/stp.jpg"));
            newStage.getIcons().add(stpIcon);
            newStage.setX(710);
            newStage.setY(50);
            ViewLoader.showStage(new STP(), "/view/stp.fxml", 
                    "STP Report", newStage);
        }catch(Exception event){
//            System.out.println("Something went wrong");
        }
    }
    
    @FXML private void handleClose(ActionEvent e) throws Exception{
        stage.close();
    }
    

}
