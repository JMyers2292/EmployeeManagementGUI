package controller;

import au.edu.uts.ap.javafx.Controller;
import java.text.DecimalFormat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import model.*;


public class PaygController extends Controller<Employee> {
   @FXML private Text weeklyPayTxt;
   @FXML private Text grossTxt;
   @FXML private Text netTxt;
   @FXML private Text superTxt;
   @FXML private Text hourPayTxt;
   @FXML private Text taxTxt;
   @FXML private Text deductionTxt;
   @FXML private Text superRateTxt;
           
   public final Employee getEmployee(){ return model; }
   
   private void setHours(int hours){
       weeklyPayTxt.setText(hours + " hours");
   }
   
   private void setMoney(Text name, double value){
       name.setText(new DecimalFormat("$#####0.00").format(value));
   }
   
   private void setRate(Text name, double rate){
       name.setText(new DecimalFormat("#####0.00%").format(rate));
   }
   
   @FXML public void initialize(){
       setHours(getEmployee().getHours());
       setMoney(grossTxt, getEmployee().getIncome());
       setMoney(netTxt, getEmployee().getNet());
       setMoney(superTxt, getEmployee().getSuper());
       setMoney(hourPayTxt, getEmployee().getPayPerHour());
       setRate(taxTxt, getEmployee().getRate());
       setMoney(deductionTxt, getEmployee().getDeduction());
       setRate(superRateTxt, getEmployee().getSuperRate());
   }
   
   @FXML private void handleClose(ActionEvent e) throws Exception{
       stage.close();
   }
}
