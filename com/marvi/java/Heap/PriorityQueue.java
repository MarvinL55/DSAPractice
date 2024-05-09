package com.marvi.java.Heap;

import java.util.Arrays;

public class PriorityQueue {

    // Array to hold the heap
    private int[] heap;
    // The size of the heap
    private int size;
    // The capacity of the array
    private int capacity;

    // A constructor to get everything going 
    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    // Insert method
    public void insert(int item) {
        // If the size is grater or equal to the capacity if it is it is set to full
        if (size >= capacity) {
            System.out.println("Priority queue is full");
            return;
        }
        // adds the item to the heap
        heap[size] = item;
        // Increases the heap size
        size++;
        // Moves an element in the heap up 
        heapifyUp(size - 1);
    }

    // Deletes an element
    public int extractMax() {
        // checks if it's empty first then prints out a that the heap is empty 
        if(isEmpty()){
            System.out.println("Sorry the heap is empty.");
            return -1;
        }

        // Accessing the first element in the array
        int max = heap[0];
        // deletes the element from the heap 
        heap[0] = heap[size - 1];
        heapifyDown(0);
        return max;
    }

    // Bring down a element if need be 
    private void heapifyDown(int index) {
        // Checks if it has a left child
        while(hasLeftChild(index)){
            // Gets the maximum element to move down 
            int maxChildIndex = getMaxChildIndex(index);
            if(heap[index] < heap[maxChildIndex]){
                swap(index, maxChildIndex); // Swap with the bigger child
                index = maxChildIndex; // Keep moving down the heap.
            } else {
                break; // breaks the loop
            }
        }
    }

    // Checks if the heap is empty 
    private boolean isEmpty() {
        // It does so by checking if the size is equal to zero
       return size == 0;
    }

    // Checks if the heap is full
    public boolean isFull(){
        // Checks if the size is equal to the capacity
        return size == capacity;
    }

    // brings an element up after another element is removed 
    private void heapifyUp(int index){
        // Loops until the node has a parent and violates the heap property
        while(hasParent(index) && heap[index] > heap[getParentIndex(index)]){
            // Swap the node with it's parent if one is violating the heap order
            swap(index, getParentIndex(index));
            // Moves up to the parent index
            index = getParentIndex(index);
        }
    }

    // Swaps the elements in the heap
    private void swap(int index1, int index2){
        // puts the variable to stored in a temporary the value of index1
        int temp = heap[index1];
        // Puts the value of index2 to index1
        heap[index1] = heap[index2];
        // Puts the variable in a temporary the value to index 2
        heap[index2] = temp;
    }

    // Prints out the list 
    private void printHead() {
        System.out.println(Arrays.toString(heap));
    }

    // Gets the parent index
    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    // Get the left child index
    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    // Get the right child index
    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    // Checks if it has a parent 
    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    // Checks if it has a left child node 
    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    //  Checks if it has a right child node 
    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    // Gets the max child in the queue
    private int getMaxChildIndex(int index) {
        // Calculate the indexes of the left and right child
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getLeftChildIndex(index);

        // Checks if the right child exists and if it's grater than the left child
        if (rightChildIndex < size && heap[rightChildIndex] > heap[leftChildIndex]) {
            // Return the index of the right child
            return rightChildIndex;
        } else {
            // Returns the index of the left child 
            return leftChildIndex;
        }
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
        System.out.println("Extracted max value: " + max);
        maxHeap.printHeap();
    }
}
