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
public class FinancialmanagementController implements Initializable {

    @FXML
    private PieChart financialPieChart;

    private ObservableList< PieChart.Data> list = FXCollections.observableArrayList();
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadButtonOnClick(ActionEvent event) {
        financialPieChart.getData().clear();
        list.add(new PieChart.Data("Inventory Cost 50%", 50));
        list.add(new PieChart.Data("Staffing & Volunteers 15%", 15));
        list.add(new PieChart.Data("Marketing & Promotion 10%", 10));
        list.add(new PieChart.Data("Venue & Set Up 10%", 10));
        list.add(new PieChart.Data("Transaction Fees%", 5));
        list.add(new PieChart.Data("Contingency 10%", 10));

        // Set the preferred size of the pie chart
        financialPieChart.setPrefSize(450, 350);

        // Set the pie chart to show percentage labels
        financialPieChart.setLabelsVisible(true);
        financialPieChart.setStartAngle(90);

        financialPieChart.setData(list);
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
