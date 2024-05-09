class Node{
    // The data in the linked list
    int data;
    // Pointer that points to the next node
    Node next;

    // Constructor that creates the nodes
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

class QueueLinked{
    // The front node in the queue
    private Node front;
    // The last node in the queue
    private Node rear;
    
    // The initialization of the front and rear of the queue 
    public QueueLinked(){
        front = null;
        rear = null;
    }

    public void Enqueue(int value){
        // Creates the node 
        Node newNode = new Node(value);
        // Checks if it's empty if it is it adds to the front 
        if(isEmpty()){
            // If the queue is empty, set both front and rear to the new node
            // Because theres only one in there at that moment
            front = newNode;
            rear = newNode;
        }else{
            // If the queue is not empty it adds a new node to the end of the queue front has it's own pointers
            rear.next = newNode;
            // Updates rear to point to the new node because it has it's own pointers
            rear = newNode;
        }
    }

    public int Dequeue(){
        // Checks if the queue is empty 
        if(isEmpty()){
            // Prints the message that lets you know it's empty
            System.out.println("The queue is empty. Nothing to remove");
            return -1;
        }
        // This gets the current value in front of the queue
        int value = front.data;

        // This skips over the node (deleting it) from the linked queue
        front = front.next;

        // This checks if it's empty overall
        if(front == null){
            // If the queue is empty update the rear point to null
            rear = null;
        }
        // This returns the value 
        return value;
    }

    public int peek(){
        // Checks if the queue is empty 
        if(isEmpty()){
            // Prints a message if the queue is empty
            System.out.println("The stack is empty. There's nothing to peek at.");
            return -1;
        }
        // Returns the front data
        return front.data;
    }

    // Checks if it's empty
    public boolean isEmpty(){
        // If the front of the stack is empty it would return nothing
        return front == null;
    }
}

public class LinkedQueue {
    public static void main(String[] args) {
        
    }
}
