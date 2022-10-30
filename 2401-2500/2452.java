class Solution {
      public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        for (String q : queries) {
            if (Arrays.stream(dictionary).anyMatch(w -> IntStream.range(0, w.length()).filter(i -> w.charAt(i) != q.charAt(i)).count() <= 2)) {
                ans.add(q);
            }
        }
        return ans;
    }
}
