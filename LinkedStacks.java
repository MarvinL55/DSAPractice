class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

class Linked{
    // The node at the top of the stack
    private Node top;

    // This make sure the top is empty 
    public Linked(){
        top = null;
    }

    // inserts the ew element to the top of the stack
    public void push(int data){
        // creates the element
        Node newNode = new Node(data);
        // this connects the new node to the top
        newNode.next = top;
        // makes it point to the reference 
        top = newNode;
    }

    // This removes the top stack
    public int pop(){
        // Checks if it's empty
        if(isEmpty()){
            // Returns a message if it is 
            System.out.println("Stack is empty. cannot pop");
            return -1;
        }
        // Stores the top node 
        int value = top.data;
        // This makes the the top node point to the next node below the top 
        top = top.next;
        // This returns the value
        return value;
    }

    // Shows whats on the top of the stack 
    public int peek(){
        // Checks if the stack is empty and if it is then it returns the messages 
        if(isEmpty()){
            System.out.println("Stack is empty. Cannot peek");
            return -1;
        }
        // Returns the top node
        return top.data;
    }

    // Checks if it's empty 
    public boolean isEmpty(){
        // If it's null theres nothing and it returns true
        return top == null;
    }
}

public class LinkedStacks {
    public static void main(String[] args) {
        Linked stack = new Linked();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        
        System.out.println("Top element: " + stack.peek());

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());

        System.out.println("Top element after popping: " + stack.peek());

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());

        System.out.println("Top element after popping: " + stack.peek());
    }
}
