/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;


import Data.Edge;
import Data.Vertex;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javafx.geometry.Point2D;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

/**
 *
 * @author Carlos
 */
public class Graph {
    
    private Map<Vertex, List<Edge>> listAbj;


    public Graph(){
        listAbj = new HashMap<>();
    }
    

    public boolean addVertex(String name, double x, double y){

        Set<Vertex> keys = listAbj.keySet();
        
        for(Vertex v: keys){
            if(v.getName().equals(name)){
                return false;
            }
        }

        Vertex v = new Vertex(name, x, y);

        listAbj.put(v, new ArrayList<Edge>());

        return true;
    }

    public void addVertex(double x, double y){
        int num = listAbj.size() + 1;

        Vertex v = new Vertex("" + num, x, y);

        listAbj.put(v, new ArrayList<Edge>());
    }

    public boolean addEdge(String star, String end, double weight){

        Vertex Star = null;
        Vertex End = null;

        Set<Vertex> keys = listAbj.keySet();
        
        for(Vertex v: keys){
            if(v.getName().equals(star)){
                Star = v;
            }

            if(v.getName().equals(end)){
                End = v;
            }
        }

        if(Star == null || End == null){
            return false;
        }

        List<Edge> aux = listAbj.get(Star);

        for(Edge e: aux){
            if(e.getTarget().getName().equals(end)){
                return false;
            }
        }

        Edge e = new Edge(End, weight);

        aux.add(e);

        return true;
    }


    public void printList(){

        Set<Vertex> keys = listAbj.keySet();
        
        for(Vertex v: keys){
            System.out.print(v.getName() + " --> ");

            List<Edge> list= listAbj.get(v);

            for(Edge e: list){
                System.out.print(e.getTarget().getName() + " --> ");
            }

            System.out.print("Null");

            System.out.println();
        }


    }
    
    
    public Vertex isPointInsideCircle(Double x, Double y){
        
        Set<Vertex> keys = listAbj.keySet();
        
        for(Vertex v: keys){
            
            Circle circle = v.getCircle();
            
            double centerX = circle.getCenterX();
            double centerY = circle.getCenterY();
            double radius = circle.getRadius();
            
            double distance = Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2));
            
            if(distance <= radius){
                
                return v;
                
            }
        }
        
        return null;
    }
    
    public void paint(AnchorPane pane){
        
        Set<Vertex> keys = listAbj.keySet();
        
        for(Vertex v: keys){
            v.unpaint(pane);
        }
        
        for(Vertex v: keys){
            v.paint(pane);
        }
    }
}
