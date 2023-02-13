class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        // We will create a hashmap to store all the possible 
        // decimal values that our given string can offer
        // A number can have at max 32 bits
        // So a we can take a substring of length at max 32 
        // and convert it to a decimal value
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            // leading 0
            if (s.charAt(i) == '0') {
                // put the 0 along with its start and end (left & right)
                map.putIfAbsent(0, new int[] {i, i});
                continue;   // move on
            }
            
            // otherwise we will create the decimal value
            int num = 0;
            // iterate from here an create decimal value for each binary substring
            for (int j = i; j < s.length() && j < i + 32; j++) {
                num *= 2;   
                num += (s.charAt(j) - '0');
                // put the number in the map along with its start and end 
                map.putIfAbsent(num, new int[] {i, j});
            }

            // we want to keep the minimum left in case of multiple same numbers
            // putIfAbsent() puts the first ever instance found into the map
            // if we encounter same number again, it won't overwrite (like put()) 
            // because we already have the number (key) with its start & end 
        }

        // initialise answer array
        int[][] ans = new int[queries.length][2];
        int i = 0;
        for (int[] q : queries) {
            int val = q[0] ^ q[1];  // get the xor value
            // if the value exists in the map, we put its {left, right} in ans
            // else put {-1, -1} at that place
            ans[i++] = map.getOrDefault(val, new int[] {-1, -1});
        }

        return ans;
    }
}
