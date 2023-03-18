class Solution {
    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks,(t1,t2)->(t1[1]==t2[1])?t1[0]-t2[0]:t1[1]-t2[1]);
        Set<Integer> used = new HashSet<>();
        int answer = 0;
        for(int[] task: tasks){
            int usedTime = 0;
            for(int i=task[0];i<=task[1];i++) if(used.contains(i)) usedTime++;
            int time_left = task[2]-usedTime;
            for(int i=task[1];time_left>0;i--){
                if(used.add(i)){
                    answer++;
                    time_left--;
                }
            }
        }
        return answer;
    }
}
