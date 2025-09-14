import java.util.*;

class Solution {
    private boolean isVowel(char c) {
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }
    private String maskVowels(String s) {
        char[] arr = s.toCharArray();
        for (int i=0;i<arr.length;i++) {
            if (isVowel(arr[i])) arr[i] = 'a';
        }
        return new String(arr);
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>(Arrays.asList(wordlist));
        Map<String,String> lowerMap = new HashMap<>();
        Map<String,String> vowelMap = new HashMap<>();

        for (String w : wordlist) {
            String wl = w.toLowerCase(Locale.ROOT);
            lowerMap.putIfAbsent(wl, w);
            String masked = maskVowels(wl);
            vowelMap.putIfAbsent(masked, w);
        }

        String[] ans = new String[queries.length];
        for (int i=0;i<queries.length;i++) {
            String q = queries[i];
            if (exact.contains(q)) {
                ans[i] = q;
                continue;
            }
            String ql = q.toLowerCase(Locale.ROOT);
            if (lowerMap.containsKey(ql)) {
                ans[i] = lowerMap.get(ql);
                continue;
            }
            String qMasked = maskVowels(ql);
            if (vowelMap.containsKey(qMasked)) {
                ans[i] = vowelMap.get(qMasked);
            } else {
                ans[i] = "";
            }
        }
        return ans;
    }
}
