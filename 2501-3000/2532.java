class Solution {
    public int findCrossingTime(int n, int k, int[][] time) {
        int ans = 0, free = 0; 
        PriorityQueue<int[]> l = new PriorityQueue<>((a, b)->(a[0]-b[0])); 
        PriorityQueue<int[]> r = new PriorityQueue<>((a, b)->(a[0]-b[0])); 
        PriorityQueue<int[]> ll = new PriorityQueue<>((a, b)->(a[0] != b[0] ? b[0]-a[0] : b[1]-a[1]));
        PriorityQueue<int[]> rr = new PriorityQueue<>((a, b)->(a[0] != b[0] ? b[0]-a[0] : b[1]-a[1])); 
        for (int i = 0; i < time.length; ++i) 
            ll.add(new int[]{time[i][0]+time[i][2], i}); 
        while (n > 0 || r.size() > 0 || rr.size() > 0) {
            if (rr.isEmpty() && (r.isEmpty() || r.peek()[0] > free) && (n == 0 || ll.isEmpty() && (l.isEmpty() || l.peek()[0] > free))) {
                int cand = Integer.MAX_VALUE; 
                if (n > 0 && l.size() > 0) cand = Math.min(cand, l.peek()[0]); 
                if (r.size() > 0) cand = Math.min(cand, r.peek()[0]); 
                free = cand; 
            }
            while (l.size() > 0 && l.peek()[0] <= free) {
                int i = l.poll()[1]; 
                ll.add(new int[] {time[i][0] + time[i][2], i}); 
            }
            while (r.size() > 0 && r.peek()[0] <= free) {
                int i = r.poll()[1]; 
                rr.add(new int[] {time[i][0] + time[i][2], i}); 
            }
            if (rr.size() > 0) {
                int i = rr.poll()[1]; 
                free += time[i][2]; 
                if (n > 0) l.add(new int[] {free+time[i][3], i}); 
                else ans = Math.max(ans, free); 
            } else {
                int i = ll.poll()[1]; 
                free += time[i][0]; 
                r.add(new int[] {free+time[i][1], i}); 
                --n; 
            }
        }
        return ans; 
    }
}
