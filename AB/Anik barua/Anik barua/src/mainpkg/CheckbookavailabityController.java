/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ANIK
 */
public class CheckbookavailabityController implements Initializable {

    @FXML
    private ComboBox<checkbookavailabity> booktypeComboBox;
    @FXML
    private TableView<checkbookavailabity> tableView;
    @FXML
    private TableColumn<checkbookavailabity ,String> booknameColum;
    @FXML
    private TableColumn<checkbookavailabity ,String> booktypeColum;
    @FXML
    private TableColumn<checkbookavailabity ,String> priceColum;
    @FXML
    private TextField pricelabel;
    @FXML
    private TextField booknamelabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
       booknameColum.setCellValueFactory(new PropertyValueFactory<checkbookavailabity, String>(" bookname"));
       booktypeColum.setCellValueFactory(new PropertyValueFactory<checkbookavailabity, String>("booktype"));
       priceColum.setCellValueFactory(new PropertyValueFactory<checkbookavailabity, String>("price"));
       
    }    

    @FXML
    private void searchButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
  Parent scene2Parent = FXMLLoader.load(getClass().getResource("UserLogin.fxml"));
         Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();       
         window.setScene(scene2);
         window.show();
    }
    

    @FXML
    private void priceMouseOnClick(MouseEvent event) {
       pricelabel .setText(null);
    }

    @FXML
    private void booknameMouseOnClick(MouseEvent event) {
         booknamelabel.setText(null);
    }
    
}
