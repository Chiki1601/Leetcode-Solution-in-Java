class Solution {
    private int[] parents; //parents[i] => parent of vertex i if tree was rooted at vertex 0.
    int answer=0;      //required answer
    int k;
    List<List<Integer>> tree;
    List<HashSet<Integer>> guess_graph;
    public int rootCount(int[][] edges, int[][] guesses, int k) {
        this.tree = new ArrayList<>();
        this.guess_graph = new ArrayList<>();
        this.k = k;
        int n = edges.length+1;
        for(int i=0;i<n;i++) {
            tree.add(new ArrayList<>());   //Initialize tree and guesses
            guess_graph.add(new HashSet<>());
        }
        for(int[] edge: edges){
            tree.get(edge[0]).add(edge[1]);  //Fill the tree
            tree.get(edge[1]).add(edge[0]);
        }
        for(int[] g: guesses){
            guess_graph.get(g[0]).add(g[1]); //Fill guesses
        }
        parents = new int[n];
        int correct_guesses = 0;
        fill_parent(0,-1);  //Fill the parents array
        for(int i=1;i<n;i++){
            int p = parents[i];
            if(guess_graph.get(p).contains(i)) correct_guesses++;  //If its a correct guess increase the number of guesses
        }
        if(correct_guesses >= k) answer++;  //If 0 is a possible node increase answer
        for(int c: tree.get(0)) dfs(c,0, correct_guesses); //Second dfs
        return answer;
    }
    private void fill_parent(int node,int parent){
        parents[node] = parent;
        for(int child: tree.get(node)){
            if(child==parent) continue;
            fill_parent(child,node);
        }
    }
    private void dfs(int node, int parent,int correct_guesses){
        int cur = correct_guesses;
        if(guess_graph.get(parent).contains(node)) cur--;
        if(guess_graph.get(node).contains(parent)) cur++;
        if(cur>=k) answer++;
        for(int child: tree.get(node)){
            if(child!=parent) dfs(child,node,cur);
        }
    }
}
