import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private static final int INF = 2147483647;
    private static final int[] DIRS = {0, 1, 0, -1, 0};

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;

        int m = rooms.length, n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();

            for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

         while (!queue.isEmpty()) {
            int[] gate = queue.poll();
            int row = gate[0];
            int col = gate[1];

            for (int i = 0; i < 4; i++) {
                int newRow = row + DIRS[i];
                int newCol = col + DIRS[i + 1];

                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && rooms[newRow][newCol] == INF) {
                    rooms[newRow][newCol] = rooms[row][col] + 1; // Update distance
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }
}
