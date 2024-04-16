/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ANIK
 */
public class RemoveBookFromInventoryScenceController implements Initializable {

    @FXML
    private TableView<?> tableView;
    @FXML
    private TableColumn<?, ?> bookNameColum;
    @FXML
    private TableColumn<?, ?> writerNameColum;
    @FXML
    private TableColumn<?, ?> publisherColum;
    @FXML
    private TextField bookNamelabel;
    @FXML
    private TextField writerNamelabel;
    @FXML
    private TextField publisherlabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void removeButtonOnClick(MouseEvent event) {
    }

    @FXML
    private void showButtonOnClick(MouseEvent event) {
    }

    @FXML
    private void backButtonOnClick(MouseEvent event) {
    }

    @FXML
    private void booklabelMouseOnClick(MouseEvent event) {
    }

    @FXML
    private void writerNameMouseOnClick(MouseEvent event) {
    }

    @FXML
    private void publisherMouseOnClick(MouseEvent event) {
    }
    
}
