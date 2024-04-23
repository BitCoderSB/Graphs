/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

/**
 *
 * @author Carlos
 */
public class Edge {
    
    private Vertex target;
    private double weight;
    private Line line;
    private Label title;
    private Polygon Triangle;
    

    public Edge(Vertex target, double weight, double x, double y) {
        
        Triangle = new Polygon(100.0, 100.0, 200.0, 200.0, 50.0, 200.0);
        Triangle.getStyleClass().add("myTriangle");
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
    }
    
    public void paint(AnchorPane pane){
        
        //////////////////////////////////////// Triangle //////////////////////////////////////////////////////
        
        Triangle.getPoints().clear();
        
        double[] points = new double[6];
        double size = 20;
        double height = Math.sqrt((size * size) - ((size / 2) * (size / 2)));
                
        double x = target.getCircle().getCenterX();
        double y = target.getCircle().getCenterY();
        
        double x1 = line.getStartX();
        double y1 = line.getStartY();
        
        x1 = x1 - x;
        y1 = y1 - y;
        
        double magnitud = Math.sqrt((x1 * x1) + (y1 * y1));
        
        points[4] = ((x1 / magnitud) * target.getCircle().getRadius()) + x;
        points[5] = ((y1 / magnitud) * target.getCircle().getRadius()) + y;
        
        
        x1 = (x1 / magnitud) * (height + target.getCircle().getRadius());
        y1 = (y1 / magnitud) * (height + target.getCircle().getRadius());
        
        line.setEndX(x1 + x);
        line.setEndY(y1 + y);
        double px = y1;
        double py = -x1;
        
        double magnitud2 = Math.sqrt((px * px) + (py * py));
        
        points[0] = (y1 / magnitud2) * (size / 2) + x1 + x;
        points[1] = (-x1 / magnitud2) * (size / 2) + y1 + y;
        
        points[2] = (-y1 / magnitud2) * (size / 2) + x1 + x;
        points[3] = (x1 / magnitud2) * (size / 2) + y1 + y;
        
        
        Triangle.getPoints().add(points[0]);
        Triangle.getPoints().add(points[1]);
        
        Triangle.getPoints().add(points[2]);
        Triangle.getPoints().add(points[3]);
        
        Triangle.getPoints().add(points[4]);
        Triangle.getPoints().add(points[5]);

        
        
        title.setLayoutX((double) ((line.getStartX() + line.getEndX()) / 2));
        title.setLayoutY((double) (( line.getStartY() + line.getEndY()) / 2) - 30);
        
        
        pane.getChildren().add(line);
        pane.getChildren().add(title);
        pane.getChildren().add(Triangle);
        
    }
    
    public void unpaint(AnchorPane pane){
        pane.getChildren().remove(Triangle);
        pane.getChildren().remove(title);
        pane.getChildren().remove(line);
        
    }
    

}






