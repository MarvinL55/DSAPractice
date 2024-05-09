package com.marvi.java.Heap;

import java.util.Arrays;

public class Heap {

    private int[] heap; // The array to store the heap
    private int size; // The size of the heap
    private int capacity; // The capacity of the head 

    // constructor to initialize the hep with the capacity
    public Heap(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    // Method to get the index of the parent node of a given index
    private int getParentIndex(int index){
        return (index - 2) / 2;
    }

     // Method to get the index of the left child node of a given index
    private int getLeftChildIndex(int index){
        return 2 * index + 1;
    }

    // Method to get the index of the right child node of a given index
    private int getRightChildIndex(int index){
        return 2 * index + 2;
    }

    // Method checks if a node has a parent node
    private boolean hasParent(int index){
        return getParentIndex(index) >= 0;
    }

    // Method to check if a node has a left child
    private boolean hasLeftChild(int index){
        return getLeftChildIndex(index) < size;
    }

    // Method to check if a node has a left child
    private boolean hasRightChild(int index){
        return getRightChildIndex(index) < size;
    }

    // Method to swap two elements in the heap
    private void swap(int index1, int index2){
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    // Method to insert a new element into the heap
    public void insert(int value){
        if(size >= capacity){
            System.out.println("heap is full");
            return;
        }
        heap[size] = value; // Adds the new value to the end of the array
        size++; // Increments the size of the heap
        heapifyUp(size -1); // Fix the heap property by moving the new value up to the head
    }

    // method to maintain the heap property by moving a node up the head
    private void heapifyUp(int index) {
       while (hasParent(index) && heap[index] > heap[getParentIndex(index)]) {
        swap(index, getParentIndex(index)); // Swaps the node with it's parent if necessary
        index = getParentIndex(index); // Move up to the parent index
       }
    }

    // Method to extract the maximum element from the heap
    public int extractMax(){
        if(size == 0){
            System.out.println("Heap is empty");
            return -1;
        }

        int max = heap[0]; // Stores the maximum value
        heap[0] = heap[size - 1]; // Replace the root with the last element
        size--; // Decrement the size of the heap;
        heapifyDown(0); // Fix the heap property by moving the new root down the heap
        return max;
    }

    // Method to maintain the heap property by moving a node down the heap
    private void heapifyDown(int index) {
        while(hasLeftChild(index)){
            int maxChildindex = getLeftChildIndex(index);
            if(hasRightChild(index) && heap[getRightChildIndex(index)] > heap[maxChildindex]){
                maxChildindex = getRightChildIndex(index);
            }
            if(heap[index] < heap[maxChildindex]){
                swap(index, maxChildindex);// Swap the node with it's largest child if necessary
                index = maxChildindex; // Move down the child index
            }else{
                break; // Stop if the heap property is satisfied
            }
        }
    }

    // Method to print the elements in the heap
    public void printHeap(){
        System.out.println(Arrays.toString(heap));
    }
    public static void main(String[] args) {
        Heap maxHeap = new Heap(10);
        maxHeap.insert(10);
        maxHeap.insert(5);
        maxHeap.insert(20);
        maxHeap.insert(15);
        maxHeap.insert(30);
        maxHeap.printHeap();

        int max = maxHeap.extractMax();
        System.out.println("Extract max value: " + max);
        maxHeap.printHeap();
    }
}
