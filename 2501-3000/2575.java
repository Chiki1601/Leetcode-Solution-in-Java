class Solution {
    public int[] divisibilityArray(String word, int m) {
        long x=0;
        int n=word.length();
        int[] ans = new int[n];
        for(int i=0;i<word.length();i++)
        {
            x=x*10+(word.charAt(i)-'0');
            if(x%m==0) ans[i]=1;else ans[i]=0;
            x%=m;
        }
        return ans;
    }
}
