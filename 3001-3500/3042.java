class Solution {
    
    static boolean helper(String s1, String s2){
        int n = s1.length();
        
        String a = s2.substring(0,n);
        String b = s2.substring(s2.length()-n);
        
        if(s1.equals(a) && s1.equals(b)) return true;
        else return false;
    }
    public int countPrefixSuffixPairs(String[] arr) {
        int n = arr.length;
        
        int ans = 0;
        
        for(int i=0; i<n; i++){
            String s1 = arr[i];
            for(int j=i+1; j<n; j++){
                String s2 = arr[j];
                if(s2.length()>=s1.length()){
                    if(helper(s1,s2)) ans++;
                }
            }
        }
        return ans;
    }
}
