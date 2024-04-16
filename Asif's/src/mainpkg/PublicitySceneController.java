/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class PublicitySceneController implements Initializable {

    @FXML
    private PieChart publicityPieChart;
    
    private ObservableList< PieChart.Data> list = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showButtonOnClick(ActionEvent event) {
        publicityPieChart.getData().clear();
        list.add(new PieChart.Data("Social Media", 25));
        list.add(new PieChart.Data("Press Releases 10%", 10));
        list.add(new PieChart.Data("Author Events 50%", 50));
        list.add(new PieChart.Data("Website Traffic 15%", 15));
        

        // Set the preferred size of the pie chart
      publicityPieChart.setPrefSize(500, 400);

        // Set the pie chart to show percentage labels
       publicityPieChart.setLabelsVisible(true);
       publicityPieChart.setStartAngle(90);

       publicityPieChart.setData(list);
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
