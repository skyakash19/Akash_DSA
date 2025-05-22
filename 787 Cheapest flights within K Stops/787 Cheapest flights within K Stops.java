public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] costs = new int[n];
        java.util.Arrays.fill(costs, Integer.MAX_VALUE);
        costs[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] temp = costs.clone();n
            for (int[] flight : flights) {
                int u = flight[0], v = flight[1], cost = flight[2];
                if (costs[u] == Integer.MAX_VALUE) continue;
                if (temp[v] > costs[u] + cost) {
                    temp[v] = costs[u] + cost;
                }
            }
            costs = temp;
        }
        
        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
    }
}
