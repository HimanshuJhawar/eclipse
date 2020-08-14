package coding_Blocks.Heap;

import java.util.*;

public class MergeKSortedArray {

    static private class Node {
        int data;
        int row;
        int col;

        Node(int d, int r, int c) {
            data = d;
            row = r;
            col = c;
        }

    }

    static ArrayList<Integer> mergeKSortedArrays(int[][] arr) {
        int k = arr.length;
        int n = arr[0].length;

        ArrayList<Integer> res = new ArrayList<>();

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> ((int) (a.data - b.data)));

        for (int i = 0; i < k; i++) {
            // Push the first elements of all the rows into the PQ with their row and column
            // number
            pq.add(new Node(arr[i][0], i, 0));
        }

        while (!pq.isEmpty()) {
            // Take the smallest element out of PQ
            // Insert it into final result and push the next element of its row into the PQ
            Node t = pq.poll();
            res.add(t.data);
            int rowNo = t.row;
            int colNo = t.col;
           
            if (colNo < n - 1) {
                // Check whether the current element is last element of its row or not. If so ,
                // do nothing.
                pq.add(new Node(arr[rowNo][colNo + 1], rowNo, colNo + 1));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt(); // No of rows
        int n = sc.nextInt(); // No of cols

        int[][] arr = new int[k][n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        ArrayList<Integer> res = mergeKSortedArrays(arr);

        for (int x : res) {
            System.out.print(x + " ");
        }
    }

}

	

