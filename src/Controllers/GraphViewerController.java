/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import Data.Edge;
import Data.Vertex;
import Logic.Graph;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Set;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
    
    // Vertex
    private boolean VertexR;
    private double lastX;
    private double lastY;
    private boolean move;
    private Vertex moveV;
    
    
    
    // Edge
    
    private boolean starEdge;
    private Vertex Star;
    private Vertex End;
    @FXML
    private CheckBox checkV;
    
    /**
     * Initializes the controller class.
     */
    
    public void initialize(URL url, ResourceBundle rb) {
        moveV = null;
        move = false;
        VertexR = false;
        
        starEdge = false;
        Star = null;
        End = null;
        
        
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
    private void checkBoxV(ActionEvent event) {
        VertexR = checkV.isSelected();
        
    }


    @FXML
    private void paneClick(MouseEvent event) {
        
        
        if(event.getClickCount() == 2){
            double x = event.getX();
            double y = event.getY();
        
            Vertex existingVertex = g.isPointInsideCircle(x, y);
        
            if(existingVertex == null){
                g.addVertex(x, y);
            }
        
            g.paint(panel);
        }

    }
    
    
    
    
    
    // Move vertex
    

    @FXML
    private void panePreseed(MouseEvent event) {
        
        double x = event.getX();
        double y = event.getY();
        
        moveV = g.isPointInsideCircle(x, y);
        if(moveV != null && VertexR){
            lastX = x;
            lastY = y;
            
            move = true;
        }
        
        Star = moveV;
        
        if(!VertexR && Star != null){
            
            starEdge = true;
            
        }
    }

    @FXML
    private void paneReleased(MouseEvent event) {
        
        double x = event.getX();
        double y = event.getY();
        
        move = false;
        
        End = g.isPointInsideCircle(x , y);
        
        if( End != null && starEdge){
            
            Random random = new Random();
            
            int randomNumber = random.nextInt();
            
            randomNumber = Math.abs(randomNumber % 20);
            
            
            System.out.println("=====================================================================");
            System.out.println(g.addEdge(Star.getName(), End.getName(), randomNumber));
            g.printList();
            System.out.println("=====================================================================");
            starEdge = false;
            g.paint(panel);
        }
    }

    @FXML
    private void paneDragged(MouseEvent event) {
       
        double x = event.getX();
        double y = event.getY();
        
        if(move){
            
            Map<Vertex, List<Edge>> aux1 = g.getListAbj();
            
            Set<Vertex> keys = aux1.keySet();
            
            for(Vertex v: keys){
                
                List<Edge> edges = new ArrayList<>();
                edges = aux1.get(v);
                
                if(!v.getName().equals(moveV.getName())){
                    
                    for(Edge e: edges){
                        e.setCoordinates(v.getCircle().getCenterX(), v.getCircle().getCenterY());
                    }
                    
                }else{
                    
                    for(Edge e: edges){
                        e.setCoordinates(moveV.getCircle().getCenterX(), moveV.getCircle().getCenterY());
                    }
                }
            
            }
            
            
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
