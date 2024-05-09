class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = next;
    }
}

class LinkedNode{
    // Basically mean current like the current node in your list
    Node head;

    public LinkedNode(){
        this.head = head;
    }

    // Inserting a node at the beginning
    public void insertAtBeginning(int data){
        // Creates the node 
        Node newNode = new Node(data);
        // Sets the next pointer of the next node form the current head
        newNode.next = head;
        // Set it to be the new head
        head = newNode;
    }

    public void insertAtEnd(int data){
        // Creates the new node
        Node newNode = new Node(data);
        // If the node is empty put a new node at the start of the list 
        if(head  == null){
            // This is the new node made
            head = newNode;
        }else{
            // If it already have nodes this input them in 
            Node current = head;
            // As long as the next node does not equal null have it point to another node
            // Current starts at the head node until it reaches the null 
            while(current.next != null){
                current = current.next;
            }
            // This creates a new node that it's pointing to 
            current.next = newNode;
        }
    }

    public void insertAtPos(int data, int position){
        // If the position is less than 0 it throws a invalid position message
        if(position < 0){
            throw new IllegalArgumentException("Invalid position");
        }

        // If the position is 0 it calls the insert at the beginning method
        if(position == 0){
            insertAtBeginning(data);
        }else{
            // create the node
            Node newNode = new Node(data);
            // set the node created to be the current node
            Node  current = head;
            // starts from 0 nad goes through then position is minus 1 -
            // Because it stops right before the node it wants like if I want 3 
            // It stops at 2 and insert the new node after 2 
            // Stops before it reaches the end "current != null"
            for(int i = 0; i < position - 1 && current != null; i++){
                current = current.next;
            }

            // If the position inputted is more than the the positions in the linked list
            if(current == null){
                throw new IllegalArgumentException("Position is more then the length of the list");
            }
            //creates a pointer that connects the nodes
            // It moves to the end of the list 
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void deleteByValue(int data){
        // Checks if the list is empty
        if(head == null){
            return;
        }
        // If its the head thats being deleted then it deletes and makes the other one the new head
        if(head.data == data){
            head = head.next;
            return;
        }

        // Goes through the list and find the node it needs to delete
        Node current = head;
        while(current.next != null && current.next.data != data){
            current = current.next;
        }

        // If the value is found in the middle of the list delete it 
        if(current.next != null){
            current.next = current.next.next;
        }
    }

    public void deleteAtPos(int position){
        // It finds out if it's less than 0 and if it is it tells you its a invalid position
        if(position < 0){
            throw new IllegalArgumentException("Invalid position");
        }
        // If the position is 0, delete the head node if there is one
        if(position == 0){
            if(head != null){
                head = head.next;
            }
            return;
        }
        // Goes through the list and deletes it before the one that needs to be deleted
        Node current = head;
        for(int i = 0; i < position -1 && current != null; i++){
            current = current.next;
        }
        // Checks if the current position is valid and if the next node exists
        if(current == null || current.next == null){
            throw new IllegalArgumentException("Position is more than the list");
        }
        // Deletes the specified node by skipping over it
        current.next = current.next.next;
    }

    public void printList(){
        Node current = head;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class InsertingAndDel {
    public static void main(String[] args) {
        LinkedNode link = new LinkedNode();

        link.insertAtBeginning(5);
        link.insertAtBeginning(10);
        link.insertAtBeginning(15);

        // Prints out the data
        System.out.println("Linked list after inserting at the beginning: ");
        link.printList();

        link.insertAtEnd(20);
        link.insertAtEnd(25);

        // Prints out the data
        System.out.println("Linked list after inserting at the end: ");
        link.printList();

        // Insert a position 2
        link.insertAtPos(12, 2);

        // Print the data
        System.out.println("Linked list after inserting at the specific location: ");
        link.printList();

        // Deleting at a specific value
        link.deleteByValue(15);

        // Prints out the the list after everything was deleted
        System.out.println("Linked list after deleting a value");
        link.printList();

        // Deleting at a specific location
        link.deleteAtPos(3);

         // Prints out the the list after everything was deleted
         System.out.println("Linked list after deleting at a specific position which is 3: ");
         link.printList();
    }
}
