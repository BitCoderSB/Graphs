/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import Data.Vertex;
import Logic.Graph;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
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
import javafx.scene.shape.Circle;
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
    
    
    private double lastX;
    private double lastY;
    private boolean move;
    private Vertex moveV;
    /**
     * Initializes the controller class.
     */
    
    public void initialize(URL url, ResourceBundle rb) {
        moveV = null;
        move = false;
        BorderPane borderPane = new BorderPane();
        borderPane.setBottom(hbx);
    
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
    private void paneClick(MouseEvent event) {
        
        double x = event.getX();
        double y = event.getY();
        
        Vertex existingVertex = g.isPointInsideCircle(x, y);
        
        if(existingVertex == null){
            g.addVertex(x, y);
        }
        
        g.paint(panel);
    }
    
    
    
    
    
    // Move vertex
    

    @FXML
    private void panePreseed(MouseEvent event) {
        
        double x = event.getX();
        double y = event.getY();
        
        moveV = g.isPointInsideCircle(x, y);
        if(moveV != null){
            lastX = x;
            lastY = y;
            
            move = true;
        }
    }

    @FXML
    private void paneReleased(MouseEvent event) {
        move = false;
    }

    @FXML
    private void paneDragged(MouseEvent event) {
       
        double x = event.getX();
        double y = event.getY();
        
        if(move){
            
            Circle aux = moveV.getCircle();
            double deltaX = x - lastX;
            double deltaY = y - lastY;
            
            aux.setCenterX(aux.getCenterX() + deltaX);
            aux.setCenterY(aux.getCenterY() + deltaY);
            
            lastX = x;
            lastY = y;
            
            moveV.setCircle(aux);
            
            g.paint(panel);
            
        }
        
        
    }
      
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
