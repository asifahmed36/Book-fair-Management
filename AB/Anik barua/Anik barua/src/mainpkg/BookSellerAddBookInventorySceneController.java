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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
public class BookSellerAddBookInventorySceneController implements Initializable {

    private Label nationIDlabel;
    private Label mobileNumberlabel;
    private Label passwordlabel;
    @FXML
    private Label usernamelabel;
    
    @FXML
    private TableView<SellerInformation> sellerTable;
    @FXML
    private TableColumn<SellerInformation, String> usernameColumn;
    @FXML
    private TableColumn<SellerInformation, String> passwordColumn;
    @FXML
    private TableColumn<SellerInformation, String> mobileNumberColumn;
    @FXML
    private TableColumn<SellerInformation, String> nationIDColumn;
    @FXML
    private TextField usernameLabel;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       sellerTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
       usernameColumn.setCellValueFactory(new PropertyValueFactory<SellerInformation, String>("username"));
       passwordColumn.setCellValueFactory(new PropertyValueFactory<SellerInformation, String>("password"));
       mobileNumberColumn.setCellValueFactory(new PropertyValueFactory<SellerInformation, String>("mobileNumber"));
       nationIDColumn.setCellValueFactory(new PropertyValueFactory<SellerInformation, String>("nationID"));
    }    

    @FXML
    private void addButtonOnClick(ActionEvent event) {
         File f = null;
        FileOutputStream fos = null;
        
        DataOutputStream dos = null;

        try {
            f = new File("SellerInformation.bin");
            
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
            } else {
                fos = new FileOutputStream(f);
            }
            dos = new DataOutputStream(fos);

            dos.writeUTF(usernamelabel.getText());
            dos.writeUTF(passwordlabel.getText());
            dos.writeUTF(mobileNumberlabel.getText());
            dos.writeUTF(nationIDlabel.getText());
            
           // dos.writeUTF((String.valueOf(totalWithVat)));
            usernamelabel.setText("");
            passwordlabel.setText("");
            mobileNumberlabel.setText("");
            nationIDlabel.setText("");

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
    private void viewButtonOnClick(ActionEvent event) {
        
         try (DataInputStream dis = new DataInputStream(new FileInputStream("SellerInformation.bin"))) {
          sellerTable.getItems().clear(); 

          while (true) {
            String username = dis.readUTF();
            String password = dis.readUTF();
            String  mobileNumber= dis.readUTF();
            String  nationID= dis.readUTF();
            sellerTable.getItems().add(new SellerInformation( username ,password ,mobileNumber, nationID));//for table
        }
    } catch (EOFException e) {
        
    } catch (IOException e) {
        e.printStackTrace();
        
    }
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
         Parent scene2Parent = FXMLLoader.load(getClass().getResource("Book Seller.fxml"));
         Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();       
         window.setScene(scene2);
         window.show();
    }

    @FXML
    private void nationIDMouseOnClick(MouseEvent event) {
         nationIDlabel.setText(null);
    }

    @FXML
    private void mobileNumberMouseOnClick(MouseEvent event) {
         mobileNumberlabel.setText(null);
    }

    @FXML
    private void passwordMouseOnClick(MouseEvent event) {
        passwordlabel.setText(null);
    }

    @FXML
    private void usernameMouseOnClick(MouseEvent event) {
        usernamelabel.setText(null);
    }

    @FXML
    private void passwordLabel(ActionEvent event) {
        passwordlabel.setText(null);
    }

    @FXML
    private void mobileNumberLabel(ActionEvent event) {
        usernamelabel.setText(null);

    }

    @FXML
    private void nationIDLabel(ActionEvent event) {
        usernamelabel.setText(null);

    }
}
