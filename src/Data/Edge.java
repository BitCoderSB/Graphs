/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import javafx.geometry.Point2D;

/**
 *
 * @author Carlos
 */
public class Edge {
    
    private Vertex target;
    private double weight;

    public Edge(Vertex target, double weight) {

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
    
    

}
