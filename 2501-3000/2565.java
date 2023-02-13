class Solution {
    public int minimumScore(String s, String t) {
        int[] pre = new int[s.length()];
        for(int i=0, j=0; i<s.length() && j<t.length(); i++){
            if(i>0) pre[i] = pre[i-1];
            if(s.charAt(i) == t.charAt(j)){
                j++; pre[i]++;
            }
        }
        int c=0,ans = 0;
        for(int i=s.length()-1, j=t.length()-1; i>=0 && j>=0; i--){
            ans = Math.max(ans, c+pre[i]);
            if(s.charAt(i) == t.charAt(j)){
                j--; c++;
            }
        }
        ans = Math.max(ans, c);
        return Math.max(0, t.length()-ans);
    }
}
