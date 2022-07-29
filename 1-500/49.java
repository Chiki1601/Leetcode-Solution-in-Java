class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();// 
        for (String s : strs) {//
            int[] count = new int[26];// 26 
            for (char c : s.toCharArray()) count[c - 'a']++;//
            String key = Arrays.toString(count);//
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());// key , 
            map.get(key).add(s);// Value 
        }
        return new ArrayList(map.values());// Values 
    }
}
