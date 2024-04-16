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
 * @author ANIK
 */
public class UpdateBookQuantityScenceController implements Initializable {

    @FXML
    private TableView<UpdateBookQuantity> tableView;
    @FXML
    private TableColumn<UpdateBookQuantity,String > booknmaeColum;
    @FXML
    private TableColumn<UpdateBookQuantity,String > writerNameColum;
    @FXML
    private TableColumn<UpdateBookQuantity,String > publisherColum;
    @FXML
    private TextField writerNamelabel;
    @FXML
    private TextField publisherLabel;
    @FXML
    private TextField bookNameLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
       booknmaeColum.setCellValueFactory(new PropertyValueFactory<UpdateBookQuantity, String>("booknmae"));
       writerNameColum.setCellValueFactory(new PropertyValueFactory<UpdateBookQuantity, String>("writerName"));
       publisherColum.setCellValueFactory(new PropertyValueFactory<UpdateBookQuantity, String>("publisher"));
       
    }    

    @FXML
    private void updateButtonOnClick(MouseEvent event) {
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

            dos.writeUTF(bookNameLabel.getText());
            dos.writeUTF(publisherLabel.getText());
            dos.writeUTF( writerNamelabel.getText());
            
            
           // dos.writeUTF((String.valueOf(totalWithVat)));
            bookNameLabel.setText("");
           publisherLabel.setText("");
           writerNamelabel.setText("");
            

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
    private void backButtonOnClick(MouseEvent event) throws IOException {
     Parent scene2Parent = FXMLLoader.load(getClass().getResource("UserLogin.fxml"));
         Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();       
         window.setScene(scene2);
         window.show();
    }  
    @FXML
    private void showButtonOnClick(MouseEvent event) {
         try (DataInputStream dis = new DataInputStream(new FileInputStream("Order.bin"))) {
         tableView.getItems().clear(); 

          while (true) {
            String  booknmae = dis.readUTF();
            String writerName = dis.readUTF();
            String  publisher= dis.readUTF();
            
            tableView.getItems().add(new UpdateBookQuantity(  booknmae ,writerName ,publisher ));//for table
        }
    } catch (EOFException e) {
        
    } catch (IOException e) {
        e.printStackTrace();
        
    }
    }

    
    

    @FXML
    private void writerNameMouseOnClick(MouseEvent event) {
     writerNamelabel.setText(null);
    }

    @FXML
    private void publisherMouseOnClick(MouseEvent event) {
        publisherLabel.setText(null);
    }

    @FXML
    private void bookNameMouseOnClick(MouseEvent event) {
         writerNamelabel.setText(null);
    }
    
}
