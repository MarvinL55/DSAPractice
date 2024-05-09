

public class StackLearning {

    private int maxSize;
    private int top;
    private int[] stackArray;

    // The constructor that makes new stacks
    public StackLearning(int size){
        // This makes the max size equal to the size of it because nothing was added ao the size would be
        // the same
        maxSize = size;
        // This makes new stack 
        stackArray = new int[maxSize];
        top = -1; // Initialize the top pointer
    }

    public void push(int value){
        //Check if it's full
        if(isFull()){
            // This gives and message and returns nothing
            System.out.println("Stack is full. Cannot push.");
            return;
        }
        // This implements it and it's ++top because we want it to be the first element at the bottom
        // If top++ is used then it would be zero one then so on instead of one two and three
        stackArray[++top] = value;
    }

    // This removes things from the stack
    public int pop(int value){
        // Check if it's full
        if(isEmpty()){
            System.out.println("The stack is empty. Cannot push");
            return -1; //Returns nothing
        }
        // Removes the top element in the stack
        return stackArray[top--];
    }

    // This looks at the stack 
    public int Peek(){
        // This lets me know if it's empty and send a message saying stack is empty
        if(isEmpty()){
            System.out.println("The stack is empty. Could not peek");
            return -1;
        }
        // This shows what element in the stack is on the top 
        return stackArray[top];
    }

    // This basically lets you know if it's empty or not
    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }
   public static void main(String[] args) {

   } 
}
