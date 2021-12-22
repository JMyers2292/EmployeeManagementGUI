package controller;

import au.edu.uts.ap.javafx.Controller;
import java.text.DecimalFormat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import model.*;


public class StpController extends Controller<STP> {
    @FXML private Button closeBtn;
    
    @FXML private Text totalWageTxt;
    @FXML private Text totalTaxTxt;
    @FXML private Text totalNetTxt;
    @FXML private Text totalSuperTxt;
    @FXML private Text basTxt;
       
    @FXML private TableView<STP> stpTv;
    @FXML private TableColumn<Employee, String> nameTv;
    @FXML private TableColumn<Employee, String> wageTv;
    @FXML private TableColumn<Employee, String> taxTv;
    @FXML private TableColumn<Employee, String> netTv;
    @FXML private TableColumn<Employee, String> superTv;
    
    
    
    public final STP getSTP(){ return model; }
    
    private void setMoney(Text name, double value){
        name.setText(new DecimalFormat("$#####0.00").format(value));
    }
    @FXML public void initialize(){

        wageTv.setCellValueFactory(cellData -> cellData.getValue().incomeProperty().asString("$%.2f"));
        taxTv.setCellValueFactory(cellData -> cellData.getValue().deductionProperty().asString("$%.2f"));
        netTv.setCellValueFactory(cellData -> cellData.getValue().netProperty().asString("$%.2f"));
        superTv.setCellValueFactory(cellData -> cellData.getValue().superProperty().asString("$%.2f"));
        
                
        setMoney(totalWageTxt, getSTP().getTotalWages());
        setMoney(totalTaxTxt, getSTP().getTotalTax());
        setMoney(totalNetTxt, getSTP().getTotalNet());
        setMoney(totalSuperTxt, getSTP().getTotalSuper());
        setMoney(basTxt, getSTP().getBas());
    }
    
    @FXML private void handleClose(ActionEvent e)throws Exception{
        stage.close();
    }
}
