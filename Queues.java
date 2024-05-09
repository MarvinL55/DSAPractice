
public class Queues {
    private int maxSize;
    private int front;
    private int rear;
    private int[] queueArray;

    // Constructor creates the constraints for the size of the elements
    public Queues(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
    }

    // Adding elements to the stack
    public void enqueue(int value){
        // Checks if the stack is full
        if(isFull()){
            // Returns a message if it's full 
            System.out.println("Queue is full. Cannot enqueue");
            return;
        }
        // Adds the element in the stack at the front 
        queueArray[++rear] = value;
    }

    // Removing things from the front of the queue
    public int dequeue(){
        // Checks if the queue is empty before anything
        if(isEmpty()){
            // Returns a message if it is empty
            System.out.println("The queue is empty. There is nothing to remove");
            return -1;
        }
        // Removes the element from the front it's ++ because the queue is being moved forward 
        // Picture it as one person gets served at a line the next person comes forward
        int value = queueArray[front++]; // Removes from the front and pull the next value forward
        return value;
    }

    // Looks at the element first in the array
    public int peek(){
        // Checks if the array is empty or not 
        if(isEmpty()){
            // Returns a message of it is empty
            System.out.println("The stack is empty. Nothing to peek");
            return -1;
        }
        // Returns the element that is at the head of the queue
        return queueArray[front];
    }

    // Does the check to see if it's empty
    public boolean isEmpty(){
        // If the front is ahead of the rear it has nothing in it
        return front > rear;
    }

    // Checks if it is full
    public boolean isFull(){
        // We check if it's full by seeing if the rear is full and subtracting one for maxSize bc
        // Arrays start from zero so you have to minus one 
        return rear == maxSize - 1;
    }

    public static void main(String[] args) {
         
    }
}
