import java.util.*;

class Solution {
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        // Build the adjacency list for the tree
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        
        // BFS to find the maximum depth
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        
        queue.offer(1);
        visited[1] = true;
        
        int maxDepth = -1; // Root is at depth 0
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            maxDepth++;
            
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                
                for (int neighbor : adj[curr]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                    }
                }
            }
        }
        
        // If there's no depth (though constraint says n >= 2), return 0
        if (maxDepth <= 0) return 0;
        
        // Calculate 2^(maxDepth - 1) % (10^9 + 7) using fast exponentiation
        long ans = 1;
        long base = 2;
        int power = maxDepth - 1;
        int mod = 1000000007;
        
        while (power > 0) {
            if ((power & 1) == 1) {
                ans = (ans * base) % mod;
            }
            base = (base * base) % mod;
            power >>= 1;
        }
        
        return (int) ans;
    }
}