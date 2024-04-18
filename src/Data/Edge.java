/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

/**
 *
 * @author Carlos
 */
public class Edge {
    
    private Vertex target;
    private double weight;
    private Line line;
    private Label title;

    public Edge(Vertex target, double weight, double x, double y) {
        
        
        title = new Label("" + weight);
        title.getStyleClass().add("edgeLabel");
        
        line = new Line(x, y, target.getCircle().getCenterX(), target.getCircle().getCenterY());
        line.getStyleClass().add("myLine");
        this.target = target;
        this.weight = weight;

    }

    
    // getter
    
    public Vertex getTarget() {
        return target;
    }

    public double getWeight() {
        return weight;
    }


    // setter

    public void setTarget(Vertex target) {
        this.target = target;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    
    public void setCoordinates(double x, double y){
        
        line.setStartX(x);
        line.setStartY(y);
        line.setEndX(target.getCircle().getCenterX());
        line.setEndY(target.getCircle().getCenterY());
        
    }
    
    public void paint(AnchorPane pane){
        
        title.setLayoutX((double) ((line.getStartX() + line.getEndX()) / 2));
        title.setLayoutY((double) (( line.getStartY() + line.getEndY()) / 2) - 30);
        
        pane.getChildren().add(line);
        pane.getChildren().add(title);
        
    }
    
    public void unpaint(AnchorPane pane){
        pane.getChildren().remove(title);
        pane.getChildren().remove(line);
        
    }
    

}






