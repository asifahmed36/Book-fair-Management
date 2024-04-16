/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class MaintainstallController implements Initializable {

    @FXML
    private TextField stallnoTextField;
    @FXML
    private TextField stallnameTextField;
    @FXML
    private TextField ownernameTextField;
    @FXML
    private TableView<Stall> stallTable;
    @FXML
    private TableColumn<Stall, String> noColumn;
    @FXML
    private TableColumn<Stall, String> stallnameColumn;
    @FXML
    private TableColumn<Stall, String> ownernameColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       stallTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
       noColumn.setCellValueFactory(new PropertyValueFactory<Stall, String>("no"));
       stallnameColumn.setCellValueFactory(new PropertyValueFactory<Stall, String>("stallname"));
       ownernameColumn.setCellValueFactory(new PropertyValueFactory<Stall, String>("ownername"));
       
      
    }    

    @FXML
    private void addButtonOnClick(ActionEvent event) {
         File f = null;
        FileOutputStream fos = null;
        
        DataOutputStream dos = null;

        try {
            f = new File("Order.bin");
            
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
            } else {
                fos = new FileOutputStream(f);
            }
            dos = new DataOutputStream(fos);

            dos.writeUTF(stallnoTextField.getText());
            dos.writeUTF(stallnameTextField.getText());
            dos.writeUTF(ownernameTextField.getText());
            
            
           // dos.writeUTF((String.valueOf(totalWithVat)));
            stallnoTextField.setText("");
            stallnameTextField.setText("");
            ownernameTextField.setText("");


        } catch (IOException ex) {
           // Logger.getLogger(SearchingbookSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (IOException ex) {
               // Logger.getLogger(SearchingbookSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
      @FXML
    void stallnameMouseOnclick(MouseEvent event) {
        stallnameTextField.setText(null);

    }
      @FXML
    void ownernameMouseOnClick(MouseEvent event) {
        ownernameTextField.setText(null);

    }
      @FXML
    void stallnoMouseOnClick(MouseEvent event) {
        stallnoTextField.setText(null);

    }


    @FXML
    private void viewButtonOnClick(ActionEvent event) {
        
         try (DataInputStream dis = new DataInputStream(new FileInputStream("Order.bin"))) {
          stallTable.getItems().clear(); 

          while (true) {
            String no = dis.readUTF();
            String stallname = dis.readUTF();
            String ownername = dis.readUTF();

            stallTable.getItems().add(new Stall(no, stallname, ownername));//for table
        }
    } catch (EOFException e) {
        
    } catch (IOException e) {
        e.printStackTrace();
        
    }
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
         Parent scene2Parent = FXMLLoader.load(getClass().getResource("OrganizerScene.fxml"));
         Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();       
         window.setScene(scene2);
         window.show();
    }
  
    
    
}
