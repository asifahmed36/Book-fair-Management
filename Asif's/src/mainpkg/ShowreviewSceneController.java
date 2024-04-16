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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class ShowreviewSceneController implements Initializable {

    @FXML
    private TextArea reviewTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void viewButtonOnClick(ActionEvent event) {
    try (DataInputStream dis = new DataInputStream(new FileInputStream("customerreview.bin"))) {
            reviewTextArea.clear();  // Clear text area before displaying reviews
            String review;
            while ((review = dis.readUTF()) != null) {
                reviewTextArea.appendText(review + "\n");
            }
        } catch (EOFException e) {
            
        } catch (IOException e) {
            e.printStackTrace();
        }
      
    }

    @FXML
    private void backButtonOnClcik(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("BuyerScene.fxml"));
         Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();       
         window.setScene(scene2);
         window.show();
    }
    
}
