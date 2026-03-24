/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.awt.Color;
import java.util.ArrayList;
import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

/**
 *
 * @author Carlos
 */




public class Vertex {

    private String name;
    private Circle circle;
    private double X;
    private double y;
    private Label title;

    
    
    public Vertex(String name, double x, double y){
        this.name = name;
        this.X = x;
        this.y = y;
        
        title = new Label(name);
        title.setLayoutX(x);
        title.setLayoutY(y);
        title.getStyleClass().add("classLabel");
        
        circle = new Circle(30);
        circle.setCenterX(x);
        circle.setCenterY(y);

        circle.getStyleClass().add("myClass");
    }

    
    // getter
    public String getName() {
        return name;
    }

    public Circle getCircle() {
        return circle;
    }
    
    
    
    
    // setter
    public void setName(String name) {
        this.name = name;
        title.setText(name);
    }

    
    public void paint(AnchorPane pane){
        title.setLayoutX(circle.getCenterX());
        title.setLayoutY(circle.getCenterY());
        pane.getChildren().add(circle);
        pane.getChildren().add(title);
        
    }
    
    public void unpaint(AnchorPane pane){
        
        pane.getChildren().remove(circle);
        pane.getChildren().remove(title);
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }
    
    
}
