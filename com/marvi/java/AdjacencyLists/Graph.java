package com.marvi.java.AdjacencyLists;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {

    // A array list that stores a linked list and the linked lists stores nodes.
    ArrayList<LinkedList<Node>> alist;

    // The graph constructor to make new Nodes
    Graph(){
        alist = new ArrayList<>();
    }

    public void addNode(Node node){
        // Create a new list and adds the node to it 
        LinkedList<Node> currentList = new LinkedList<>();
        currentList.add(node);
        // Adds the list to the graph
        alist.add(currentList);
    }

    public void addEdge(int src, int dst){
        // Gets the Linkedlist of node for the source node
        LinkedList<Node> currentList = alist.get(src);
        // Gets the destination node
        Node dstNode = alist.get(dst).get(0);
        // Adds the destination node to the source nodes list
        currentList.add(dstNode);
    }

    public boolean checkEdge(int src, int dst){
        // Gets the list of nodes for the source node
        LinkedList<Node> currentList = alist.get(src);
        // Get the destination node
        Node dstNode = alist.get(dst).get(0);
        // Checks if the destination node exist in the source node list
        for(Node node : currentList){
            if(node == dstNode){
                return true;
            }
        }
        return false;
    }

    public void print(){
        // Goes through the list of node
        for(LinkedList<Node> currentList : alist){
            // Prints each nodes data
            for(Node node : currentList){
                System.out.print(node.data + " -> ");
            }
            System.out.println();
        }
    }
}
