package com.marvi.java.Heap;

import java.util.*;

public class DisjointSet {

    // Map to store the parent node of each element
    private Map<Integer, Integer> parent;

    // Map to store the rank of each element
    private Map<Integer, Integer> rank;

    public DisjointSet() {
        parent = new HashMap<>();
        rank = new HashMap<>();
    }
    
    // creates new set containing the element x
    public void makeSet(int x) {
        parent.put(x, x); // Set x as it's own parent
        rank.put(x, 0); // Set initial rank of x to 0
    }

  // Find the representative element of the set containing x
    public int find(int x) {
        if (parent.get(x) != x) {
            parent.put(x, find(parent.get(x))); // Path compression
    }
    return parent.get(x);
}

// Combines the set containing element x and y
public void union(int x, int y){
    int rootX = find(x);
    int rootY = find(y);

    if(rootX == rootY) return;

    // Union by rank
    if(rank.get(rootX) < rank.get(rootY)){
        parent.put(rootX, rootY); // Make rootY the parent of rootX
    }else if(rank.get(rootX) > rank.get(rootY)){
        parent.put(rootY, rootX); // Make rootX the parent of rootY
    }else{
        parent.put(rootY, rootX); // Make rootX the parent of rootY
        rank.put(rootX, rank.get(rootX) + 1); // Increment the rank of rootX
    }
}

    public static void main(String[] args) {
       
        DisjointSet ds = new DisjointSet();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        
        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(5, 6);
        
        System.out.println(ds.find(1)); // Should print 3
        System.out.println(ds.find(2)); // Should print 3
        System.out.println(ds.find(3)); // Should print 3
        System.out.println(ds.find(4)); // Should print 6
        System.out.println(ds.find(5)); // Should print 6
        System.out.println(ds.find(6)); // Should print 6
    }
}
