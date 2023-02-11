import java.util.*;

public class Solution {
    
    
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
    
    
    	// 用邻接表建图
        Map<Integer, List<Integer>>[] maps = (Map<Integer, List<Integer>>[]) (new HashMap[2]);
        maps[0] = new HashMap<>();
        maps[1] = new HashMap<>();
        for (int[] red_edge : red_edges) {
    
    
            int from = red_edge[0], to = red_edge[1];
            maps[0].putIfAbsent(from, new ArrayList<>());
            maps[0].get(from).add(to);
        }
        for (int[] blue_edge : blue_edges) {
    
    
            int from = blue_edge[0], to = blue_edge[1];
            maps[1].putIfAbsent(from, new ArrayList<>());
            maps[1].get(from).add(to);
        }
        
        int[] res = new int[n];
        Arrays.fill(res, -1);
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{
    
    0, -1});
        res[0] = 0;
        
        // visited[i][0]指的是从红色边到达顶点i的这个状态有没有经历过
        boolean[][] visited = new boolean[n][2];
        
        int step = 0;
        while (!queue.isEmpty()) {
    
    
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
    
    
                int[] cur = queue.poll();
                int pos = cur[0], color = cur[1];
                // 枚举下面一条路径的颜色
                for (int j = 0; j < 2; j++) {
    
    
                	// 如果颜色与上一条边颜色相同，则略过
                    if (j == color) {
    
    
                        continue;
                    }
    
                    if (maps[j].containsKey(pos)) {
    
    
                        for (int next : maps[j].get(pos)) {
    
    
                            if (!visited[next][j]) {
    
    
                                queue.offer(new int[]{
    
    next, j});
                                visited[next][j] = true;
                                // 第一次访问到next的时候就是最短距离
                                if (res[next] == -1) {
    
    
                                    res[next] = step;
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return res;
    }
}
