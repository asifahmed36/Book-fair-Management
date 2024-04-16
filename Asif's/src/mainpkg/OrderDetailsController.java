/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class OrderDetailsController implements Initializable {

    @FXML
    private TableView<Order> orderTable;
    @FXML
    private TableColumn<Order, String> booknameColumn;
    @FXML
    private TableColumn<Order, String> priceColumn;
    @FXML
    private TableColumn<Order, String> quantityColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      orderTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        booknameColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("bookname"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("price"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("quantity"));
    }    

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
         Parent scene2Parent = FXMLLoader.load(getClass().getResource("OrderScene.fxml"));
         Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();       
         window.setScene(scene2);
         window.show();
    }

    @FXML
    private void showButtonOnClick(ActionEvent event) {
         try (DataInputStream dis = new DataInputStream(new FileInputStream("Order.bin"))) {
          orderTable.getItems().clear(); // Clear existing items in the table

          while (true) {
            String bookname = dis.readUTF();
            String price = dis.readUTF();
            String quantity = dis.readUTF();

            orderTable.getItems().add(new Order(bookname, price, quantity));
        }
    } catch (EOFException e) {
        
    } catch (IOException e) {
        e.printStackTrace();
        
    }
    }
    
}
