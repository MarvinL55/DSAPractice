package com.marvi.java.BreadthFirstSearch;

public class Main {
    public static void main(String[] args) {
        BreadthFirstSearch bfs = new BreadthFirstSearch(5);

        bfs.addNode(new Node('A'));
        bfs.addNode(new Node('B'));
        bfs.addNode(new Node('C'));
        bfs.addNode(new Node('D'));
        bfs.addNode(new Node('E'));

        bfs.addEdge(0, 1);
        bfs.addEdge(1, 2);
        bfs.addEdge(2, 3);
        bfs.addEdge(2, 4);
        bfs.addEdge(4, 0);
        bfs.addEdge(4, 2);

        bfs.print();

        bfs.breadthFirstSearch(3);
    }
}
