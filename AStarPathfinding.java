import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

// Node class to represent each cell in the grid
class Node implements Comparable<Node> {
    int row, col;        // Coordinates
    double g, h, f;      // Cost values
    boolean isWall;      // Is this node an obstacle?
    Node previous;       // Reference to the previous node for path reconstruction

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
        this.g = this.h = this.f = 0;
        this.isWall = Math.random() < 0.3; // Randomly place walls
    }

    @Override
    public int compareTo(Node o) {
        return Double.compare(this.f, o.f);
    }
}

// Main class for A* Visualization
public class AStarPathfinding extends JPanel {
    private static final int SIZE = 20;  // Grid size
    private static final int WIDTH = 600, HEIGHT = 600;  // Window size
    private Node[][] grid = new Node[SIZE][SIZE];  // Grid of nodes
    private Node start, end;  // Start and end nodes
    private ArrayList<Node> openSet = new ArrayList<>();  // Open set (nodes to be evaluated)
    private ArrayList<Node> closedSet = new ArrayList<>();  // Closed set (already evaluated)
    private ArrayList<Node> path = new ArrayList<>();  // Final path

    public AStarPathfinding() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.WHITE);
        initializeGrid();
        new Timer(100, e -> {
            aStarStep();
            repaint();
        }).start();
    }

    // Initialize grid and start/end nodes
    private void initializeGrid() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = new Node(i, j);
            }
        }
        start = grid[0][0];
        end = grid[SIZE - 1][SIZE - 1];
        start.isWall = false;
        end.isWall = false;
        openSet.add(start);
    }

    // Perform one step of the A* algorithm
    private void aStarStep() {
        if (!openSet.isEmpty()) {
            // Get the node with the lowest f score
            Node current = openSet.stream().min(Node::compareTo).get();

            // If the end is reached, reconstruct the path
            if (current == end) {
                Node temp = current;
                path.add(temp);
                while (temp.previous != null) {
                    path.add(temp.previous);
                    temp = temp.previous;
                }
                return;
            }

            openSet.remove(current);
            closedSet.add(current);

            // Evaluate neighbors
            for (Node neighbor : getNeighbors(current)) {
                if (!closedSet.contains(neighbor) && !neighbor.isWall) {
                    double tempG = current.g + 1;

                    if (!openSet.contains(neighbor)) {
                        openSet.add(neighbor);
                    } else if (tempG >= neighbor.g) {
                        continue;
                    }

                    neighbor.g = tempG;
                    neighbor.h = heuristic(neighbor, end);
                    neighbor.f = neighbor.g + neighbor.h;
                    neighbor.previous = current;
                }
            }
        }
    }

    // Heuristic function (Manhattan distance)
    private double heuristic(Node a, Node b) {
        return Math.abs(a.row - b.row) + Math.abs(a.col - b.col);
    }

    // Get valid neighbors of a node
    private ArrayList<Node> getNeighbors(Node node) {
        ArrayList<Node> neighbors = new ArrayList<>();
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int newRow = node.row + dRow[i];
            int newCol = node.col + dCol[i];

            if (newRow >= 0 && newRow < SIZE && newCol >= 0 && newCol < SIZE) {
                neighbors.add(grid[newRow][newCol]);
            }
        }
        return neighbors;
    }

    // Paint the grid and the current state of the algorithm
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = WIDTH / SIZE;
        int h = HEIGHT / SIZE;

        // Draw grid
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Node node = grid[i][j];

                if (node.isWall) {
                    g.setColor(Color.BLACK);  // Obstacles are black
                } else if (path.contains(node)) {
                    g.setColor(Color.YELLOW);  // Final path is yellow
                } else if (closedSet.contains(node)) {
                    g.setColor(Color.RED);  // Closed set is red
                } else if (openSet.contains(node)) {
                    g.setColor(Color.GREEN);  // Open set is green
                } else {
                    g.setColor(Color.WHITE);  // Empty space is white
                }
                g.fillRect(node.col * w, node.row * h, w, h);
                g.setColor(Color.GRAY);
                g.drawRect(node.col * w, node.row * h, w, h);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("A* Pathfinding Visualization");
        AStarPathfinding panel = new AStarPathfinding();
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
