package com.marvi.java.BinarySearchTree;
public class BinarySearchTree {
    Node root;

    // Inserts a node into the binary search tree
    public void insert(Node node){
        // starts inserting from the root of the tree
       root = insertHelper(root, node);
    }

    // Helper method to recursively insert a node into a tree 
    private Node insertHelper(Node root, Node node){

        // Extract the data from the node being inserted
        int data = node.data;

        // If the current node is null insert the new node there
        if(root == null){
            root = node;
            return root;
        }else if(data < root.data){
            // If the data to insert is less than the root data
            // Insert on the left subtree
            root.left = insertHelper(root.left, node);
        }else{
             // If the data to insert is more than the root data
            // Insert on the right subtree
            root.right = insertHelper(root.right, node);
        }

        return root;
    }

    public void display(){
        displayHelp(root);
    }

    // Prints out the elements in increasing order
    private void displayHelp(Node root){

        // checks if the root is not empty and if it's not it displays the what's in it
        if(root != null){
            // Recursively call what's on the left side
            displayHelp(root.left);
            // prints out the nodes  
            System.out.println(root.data);
            // Recursively call what's on the right side
            displayHelp(root.right);
        }
    }

    public boolean search(int data){
        return searchHelper(root, data);
    }

    private boolean searchHelper(Node root, int data){
        // Checks if the root is empty
        if(root == null){
            // Returns false if the tree is empty
            return false;
        // If the original root is the data we're looking for returns true
        }else if(root.data == data){
            return true;
        // If the rot is more than the data we're looking for then look at the left side
        }else if(root.data > data){
            return searchHelper(root.left, data);
        }else{
            // If it's not on the left side check the right 
            return searchHelper(root.right, data);
        }
    }

    public void remove(int data){
        if(search(data)){
            removeHelper(root, data);
        }else{
            System.out.println(data + " Could not be found");
        }
    }

    private Node removeHelper(Node root, int data){
        // Checks if it's empty 
        if(root == null){
            // Returns the root because it's empty
            return root;
            // checks the left 
        } else if(data < root.data){
            root.left = removeHelper(root.left, data);
            // checks the right side 
        }else if(data > root.data){
            root.right = removeHelper(root.right, data);
        }else{
            // If it's found and it has nodes attached to it we have to shift around the nodes
            if(root.left == null && root.right == null){
                root = null;
            }else if(root.right != null){
                // Finds a successor to replace the node deleted
                root.data = successor(root);
                root.right = removeHelper(root.right, root.data);
            }else{
                // Finds a predecessor to replace the node deleted
                root.data = predecessor(root);
                root.left = removeHelper(root.left, root.data);
            }
        }
        return root;
    }

    // Find the least value below the right child of this root node
    private int successor(Node root){
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }
    // Find the greatest value below below the left child of the root node
    private int predecessor(Node root){
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }
}
