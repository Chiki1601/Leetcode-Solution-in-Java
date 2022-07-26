class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        //edge case, empty array
        if(strs==null || strs.length==0) return "";
        
        //empty string
        String ans="";
        
        //200 is the max possible length of string, as per constraints
        int minLen = 200;
        
        //finding minLen
        for(String s : strs)
            minLen = Math.min(minLen, s.length());
        
        //checking characters from index 0 to minLen-1
        for(int i=0; i<minLen; i++)
        {
            //character at index i of first string 
            char ch = strs[0].charAt(i);
            
            //looping throgh all the strings
            for(int j=0; j<strs.length; j++)
            {
                //the character differs
                if(strs[j].charAt(i) != ch)
                {
                    //ans cannot be expanded further
                    return ans;
                }
            }
            
            //ch is same across all strings, expand our answer
            ans += ch;
        }
        
        return ans;
    }
}
