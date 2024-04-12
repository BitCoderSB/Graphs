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

/**
 *
 * @author Carlos
 */
public class Graph {
    
    private Map<Vertex, List<Edge>> listAbj;


    public Graph(){
        listAbj = new HashMap<>();
    }
    

    public boolean addVertex(String name){

        Set<Vertex> keys = listAbj.keySet();
        
        for(Vertex v: keys){
            if(v.getName().equals(name)){
                return false;
            }
        }

        Vertex v = new Vertex(name);

        listAbj.put(v, new ArrayList<Edge>());

        return true;
    }

    public void addVertex(){
        int num = listAbj.size() + 1;

        Vertex v = new Vertex("" + num);

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
    
}
