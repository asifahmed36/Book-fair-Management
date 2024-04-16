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
public class TopbooksellsController implements Initializable {

    @FXML
    private PieChart topPieChart;
    
    private ObservableList< PieChart.Data> list = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void viewButtonOnClick(ActionEvent event) {
         topPieChart.getData().clear();
        list.add(new PieChart.Data("Islamic 35%", 35));
        list.add(new PieChart.Data("Science Fiction: 15%", 15));
        list.add(new PieChart.Data("Non-Fiction: 30%", 30));
        list.add(new PieChart.Data("Mystery 8%", 8));
        list.add(new PieChart.Data("Romance 2%", 2));
        list.add(new PieChart.Data("Mystery 20%", 10));

        // Set the preferred size of the pie chart
       topPieChart.setPrefSize(500, 400);

        // Set the pie chart to show percentage labels
        topPieChart.setLabelsVisible(true);
        topPieChart.setStartAngle(90);

        topPieChart.setData(list);
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("BuyerScene.fxml"));
         Scene scene2 = new Scene(scene2Parent);
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();       
         window.setScene(scene2);
         window.show();
    }
    
}
