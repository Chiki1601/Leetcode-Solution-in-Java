class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean relation[][] = new boolean[numCourses][numCourses];
        List<Boolean> ans = new ArrayList<>();

        for(int d[] : prerequisites)
        relation[d[0]][d[1]] = true;

        for(int i=0; i<numCourses; i++)
        for(int src=0; src<numCourses; src++)
        for(int target = 0; target<numCourses; target++)
        {
          relation[src][target] =  relation[src][target] || (relation[src][i] && relation[i][target]);  
        }

        for(int d[] : queries)
        ans.add(relation[d[0]][d[1]]);

        return ans;
        
    }
}
