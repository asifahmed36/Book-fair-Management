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
public class SciencefictionSceneController implements Initializable {

    @FXML
    private ComboBox<String> sciencefictionComboBox;
    @FXML
    private TableView<Science> sciencefictionTable;
    @FXML
    private TableColumn<Science, String> booknameColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         sciencefictionComboBox.getItems().addAll("Foundation","Hyperion"," The Martian" ,"Altered Carbon", " Children of Time","The City and the Stars ");
        
         sciencefictionTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
         booknameColumn.setCellValueFactory(new PropertyValueFactory<Science, String>("booklist"));
        
     
    }    

    @FXML
    private void saveButtonOnClick(ActionEvent event) {
        
        File f = null;
        FileOutputStream fos = null;
        DataOutputStream dos = null;

        try {
            f = new File("sciencebooklist.bin");
            
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
            } else {
                fos = new FileOutputStream(f);
            }
            dos = new DataOutputStream(fos);

            dos.writeUTF(sciencefictionComboBox.getValue());
           
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
    private void backButtonOnClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("BookcategoryScene.fxml"));
         Scene scene2 = new Scene(scene2Parent);
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();       
         window.setScene(scene2);
         window.show();
    }

    @FXML
    private void showButtonOnClick(ActionEvent event) {
          try (DataInputStream dis = new DataInputStream(new FileInputStream("sciencebooklist.bin"))) {
          sciencefictionTable.getItems().clear(); 

          while (true) {
            String booklist = dis.readUTF();
          

            sciencefictionTable.getItems().add(new Science(booklist));//for table
        }
    } catch (EOFException e) {
        
    } catch (IOException e) {
        e.printStackTrace();
        
    }
    }
    
}
