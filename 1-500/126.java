class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> words = new HashSet<>(wordList);

        List<List<String>> ans = new ArrayList<>();

        if (!words.contains(endWord)) {

            return ans;

        }

        

        Map<String, List<String>> adjWords = new HashMap<>();

        Map<String, Integer> dist = new HashMap<>();

        bfs(beginWord, adjWords, dist, words);

        dfs(endWord, beginWord, adjWords, dist, new ArrayList<>(), ans);

        

        return ans;

    }

    

    public void bfs(String beginWord, Map<String, List<String>> adjWords, Map<String, Integer> dist, Set<String> words) {

        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);

        dist.put(beginWord, 0);

        for (String word : words) {

            adjWords.put(word, new ArrayList<>());

        }

        

        while (!queue.isEmpty()) {

            String cur = queue.poll();

            List<String> neighbors = neighbors(cur, words);

            for (String next : neighbors) {

                adjWords.get(next).add(cur);

                if (!dist.containsKey(next)) {

                    dist.put(next, dist.get(cur) + 1);

                    queue.offer(next);

                }

            }

        }

    } 

    

    public void dfs(String curWord, String beginWord,Map<String, List<String>> adjWords, Map<String, Integer> dist, List<String> path, List<List<String>> ans) {

        path.add(curWord);

        if (curWord.equals(beginWord)) {

            Collections.reverse(path);

            ans.add(new ArrayList<>(path));

            Collections.reverse(path);

        } else {

            for (String next : adjWords.get(curWord)) {

                if (dist.containsKey(next) && dist.get(curWord) == dist.get(next) + 1) {

                    dfs(next, beginWord, adjWords, dist, path, ans);

                }

            }

        }

        

        path.remove(path.size() - 1);

    }

    

    public List<String> neighbors(String word, Set<String> words) {

        List<String> ans = new ArrayList<>();

        char[] sc = word.toCharArray();

        for (int i = 0; i < sc.length; i++) {

            char cur = sc[i];

            for (char c = 'a'; c <= 'z'; c++) {

                sc[i] = c;

                String temp = new String(sc);

                if (words.contains(temp)) {

                    ans.add(temp);

                }

            }

            sc[i] = cur;

        }

        

        return ans;

    }

}

