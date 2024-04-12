/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import Logic.Graph;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Carlos
 */
public class GraphViewerController implements Initializable {

    @FXML
    private HBox hbx;
    @FXML
    private TextField text1;
    @FXML
    private TextField text2;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private AnchorPane panel;
    @FXML
    private TextField TXT;
    
    public Graph g;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        BorderPane borderPane = new BorderPane();
        borderPane.setBottom(hbx);
        //borderPane.setPadding(new Insets(5));
    
        hbx.setAlignment(Pos.CENTER); // Alineación central
        hbx.setSpacing(10);
        
        panel.getChildren().add(borderPane);
        AnchorPane.setTopAnchor(borderPane, 0.0);
        AnchorPane.setLeftAnchor(borderPane, 0.0);
        AnchorPane.setRightAnchor(borderPane, 0.0);
        AnchorPane.setBottomAnchor(borderPane, 0.0);
        
        TXT.prefWidthProperty().bind(panel.widthProperty());
        
        g = new Graph();
    }

    @FXML
    private void pressed(MouseEvent event) {
        n();
        
        double x = event.getX();
        double y = event.getY();
        
        Point2D p = new Point2D(x,y);
        
        System.out.println("X = " + p.getX() + "  Y = " + p.getY());
    }
    
    public void n(){
        
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");
        g.addVertex("E");
        g.addVertex("F");
        g.addVertex("G");

        g.addEdge("A", "B", 4.0);
        g.addEdge("A", "D", 3);
        g.addEdge("B", "D", 2);
        g.addEdge("B", "E", 5);
        g.addEdge("D", "G", 2);
        g.addEdge("D", "F", 1);
        g.addEdge("D", "C", 2);
        g.addEdge("E", "G", 3);

        g.printList();
        
        
    }
      
}
