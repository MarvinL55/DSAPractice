import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class MergeSortVisualizer extends JPanel {
    private int[] array;  // Array to sort and visualize
    private int barWidth = 20;  // Width of each bar in the visualization

    public MergeSortVisualizer(int[] array) {
        this.array = array;
        setPreferredSize(new Dimension(800, 600));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the bars representing array elements
        for (int i = 0; i < array.length; i++) {
            int barHeight = array[i] * 5;  // Scale the height of the bars
            g.fillRect(i * barWidth, getHeight() - barHeight, barWidth, barHeight);
        }
    }

    // Merge sort logic that updates the visualization
    public void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
            repaint();  // Redraw the array after each merge step
            try {
                Thread.sleep(500);  // Slow down to visualize each step
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void merge(int[] arr, int l, int m, int r) {
        // Create temp arrays
        int[] left = Arrays.copyOfRange(arr, l, m + 1);
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] array = {50, 20, 90, 60, 30, 80, 70, 40, 10};  // Example array

        // Create frame for visualization
        JFrame frame = new JFrame("Merge Sort Visualization");
        MergeSortVisualizer visualizer = new MergeSortVisualizer(array);
        frame.add(visualizer);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Start sorting and visualizing
        new Thread(() -> visualizer.mergeSort(array, 0, array.length - 1)).start();
    }
}
