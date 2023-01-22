class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        long res = 0, sum = 0;
        int n = nums1.length;
        ArrayList<Pair> al = new ArrayList<>();
        for(int i = 0; i < n; i++)
            al.add(new Pair(nums1[i], nums2[i]));
        Collections.sort(al,(a1,a2) -> a2.y - a1.y);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < k - 1; i++){
            pq.offer(al.get(i).x);
            sum += al.get(i).x;
        }
        for(int i = k - 1; i < n; i++){
            int a = al.get(i).x;
            pq.offer(a);
            sum += a;
            if(pq.size() > k){
                sum -= pq.peek();
                pq.poll();
            }
            res = Math.max(res, (long)al.get(i).y * (long)(sum));
        }
        return res;
    }
}

class Pair{
    int x,y;
    Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}
