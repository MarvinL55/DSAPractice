class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class List {
    Node head;

    public List() {
        this.head = null;
    }

    public void insertAtBeginning(int data) {
        // Regular Node implementation
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.next = head; // Except here this make sure that it points back to the head
        } else {
            // If the lis is not empty, insert a new node at the beginning.
            newNode.next = head;
            // Traverses the list until the last node is found
            Node current = head;
            while (current != head) {
                current = current.next;
            }
            // Connect the last node to the new node
            current.next = newNode;

            // Update to point to the new node ,
            head = newNode;
        }
    }

    public void deleteNode(int data){
        // Checks if the list is empty
        if(head == null){
            return; //Nothing there to return
        }

        // Start traversing the list from the head
        Node current = head;
        Node previous = null;

        // Traverse the circular list at least once
        do{
            // If/When we find the node with the data we want to delete
            if(current.data == data){
                // If it's not the first node, update the previous node pointer
                if(previous != null){
                    previous.next = current.next;
                }else if(current.next == head){
                    // If it's the only node in the list, set head to null
                    head = null;
                }else{
                    // If the node to delete is the first node, update head to skip it and connect the last node to the next node
                    Node lastNode = current;
                    while (lastNode.next != null) {
                        lastNode = lastNode.next;
                    }
                    lastNode.next = current.next;
                    head = current.next;
                }
                return;
            }
            //Moves to the next node 
            previous = current;
            current = current.next;
        }while(current != head);
    }
}

public class CircularLinkedList {

}
