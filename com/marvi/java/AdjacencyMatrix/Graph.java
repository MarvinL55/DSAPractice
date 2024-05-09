package com.marvi.java.AdjacencyMatrix;

import java.util.ArrayList;

public class Graph{

    // To store nodes for the graph
    ArrayList<Node> nodes;
    // The adjacency matrix representing edges between nodes
    int[][] matrix;

    // Size is the amount of nodes we have 
    Graph(int size){
        // The size of both side 
        matrix = new int[size][size];
        // starts the arraylist to hold the nodes
        nodes = new ArrayList<>();
    }

    //The method to add to the graph
    public void addNode(Node node){
        // Adds to the array list 
        nodes.add(node);
    }

    public void addEdge(int src, int dst){
        //This means there a edge between two nodes
        matrix[src][dst] = 1;
    }

    public boolean checkEdge(int src, int dst){
        // Checks if theres an edge and if there is it's true
        if(matrix[src][dst] == 1){
            return true;
        }else{
            return false;
        }
    }

    public void print(){
       // Creates space for the elements
        System.out.println("  ");

         // Prints A B C D and E at the top
        for(Node node : nodes){
            System.out.print(node.data + " ");
        }
        System.out.println();

        // Print the adjacency matrix
        for(int i = 0; i < matrix.length; i++){
            // Print the label of the node for each row
            System.out.print(nodes.get(i).data + " ");
            // Print each element of the row
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}