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
            traverseTree(root.left);
            traverseTree(root.right);
            System.out.println(root.data);
        }
    }

    // Public method to start traversal from the root
    public void startTraversal() {
        traverseTree(head);
    }
}

public class PostTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Instantiate OtherNodes class with the root node
        OtherNodes tree = new OtherNodes(root);

        // Perform post order traversal
        tree.startTraversal();
    }
}
