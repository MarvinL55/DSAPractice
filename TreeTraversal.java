class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class OtherNodes {
    private Node head;

    // Constructor to initialize the head node
    public OtherNodes(Node head) {
        this.head = head;
    }

    // Recursive method to traverse the tree as much as we can
    private void traverseTree(Node root) {
        if (root != null) {
            // Visits as many left nodes as we can
            traverseTree(root.left);
            // This goes back to the root node(the one onn top)
            System.out.println(root.data);
            // Then goes to the right side 
            traverseTree(root.right);
        }
    }

    // Public method to start traversal from the root
    public void startTraversal() {
        traverseTree(head);
    }
}

public class TreeTraversal {
    public static void main(String[] args) {
        // Creating nodes for the tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Create an instance of OtherNodes and pass the root node
        OtherNodes tree = new OtherNodes(root);

        // Start traversal from the root
        tree.startTraversal();
    }
}
