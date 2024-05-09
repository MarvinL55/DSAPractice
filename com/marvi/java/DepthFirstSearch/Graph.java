package com.marvi.java.DepthFirstSearch;

import java.util.ArrayList;

public class Graph {
    
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

    public void depthFirstSearch(int src){
        boolean[] visited = new boolean[matrix.length];
        dFShelper(src, visited);
    }

    private void dFShelper(int src, boolean[] visited) {
        // If we've visited the the element we would return 
        if(visited[src]){
            return;
        }else{
            // Marks the current node as visited 
            // The else statement is need to mark 
            visited[src] = true;
            System.out.println(nodes.get(src).data + " = visited");
        }
        // Iterate through the adjacent nodes of the current node
        for(int i = 0; i < matrix[src].length; i++){
            // If theres an edge from the current node to the adjacent node and it 
            // hasn't been visited yet this recursively visits it 
            if(matrix[src][i] == 1){
                dFShelper(i, visited);
            }
        }
        return;
    }
}