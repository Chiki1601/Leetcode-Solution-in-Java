public class Solution 
{
    public String answerString(String word, int numFriends) 
    {
        // Step 1: Edge case
        if (numFriends == 1)
        {
            return word;
        } 

        int n = word.length();
        // Step 2: Compute max part length
        int maxLen = n - numFriends + 1;
        String res = "";

        // Step 3: Scan all possible substrings
        for (int i = 0; i < n; ++i) 
        {
            int k = Math.min(n - i, maxLen);
            String substr = word.substring(i, i + k);

            // Step 4: Update result if it's better
            if (substr.compareTo(res) > 0) 
            {
                res = substr;
            }
        }

        // Step 5: Return the answer
        return res;
    }
}
