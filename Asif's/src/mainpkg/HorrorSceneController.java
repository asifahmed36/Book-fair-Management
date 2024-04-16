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
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class HorrorSceneController implements Initializable {

    @FXML
    private ComboBox<String> horrorbooklistComboBox;
    @FXML
    private RadioButton yesRadioButton;
    @FXML
    private RadioButton noRadioButton;
    @FXML
    private TableView<Horror> bookTable;
    @FXML
    private TableColumn<Horror, String> bookColumn;
    
    ToggleGroup tg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tg = new ToggleGroup();
        yesRadioButton.setToggleGroup(tg);
        noRadioButton.setToggleGroup(tg);
        
        horrorbooklistComboBox.getItems().addAll("Ghost Story","The Haunting of Hill House"," The Amityville Horror" ,"We Have Always Lived in the Castle ", " Frankenstein","error ");
        
         bookTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        bookColumn.setCellValueFactory(new PropertyValueFactory<Horror, String>("booklist"));
        
        
      
    }    

    @FXML
    private void saveButtonOnClick(ActionEvent event) {
        String permission =" ";
        if(yesRadioButton.isSelected())
            permission="Yes";
        else if (noRadioButton.isSelected()) 
            permission ="No";
        
        
        File f = null;
        FileOutputStream fos = null;
      
        DataOutputStream dos = null;

        try {
            f = new File("horrorbooklist.bin");
            
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
            } else {
                fos = new FileOutputStream(f);
            }
            dos = new DataOutputStream(fos);

            dos.writeUTF(horrorbooklistComboBox.getValue());
          
            
            
          
          


        } catch (IOException ex) {
            //Logger.getLogger(SearchingBookSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (IOException ex) {
                //Logger.getLogger(SearchingBookSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void showButtonOnClick(ActionEvent event) {
         try (DataInputStream dis = new DataInputStream(new FileInputStream("horrorbooklist.bin"))) {
          bookTable.getItems().clear(); // Clear existing items in the table

          while (true) {
            String booklist = dis.readUTF();
          

            bookTable.getItems().add(new Horror(booklist));//for table
        }
    } catch (EOFException e) {
        
    } catch (IOException e) {
        e.printStackTrace();
        
    }
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("BookcategoryScene.fxml"));
         Scene scene2 = new Scene(scene2Parent);
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();       
         window.setScene(scene2);
         window.show();
    }
    
}
