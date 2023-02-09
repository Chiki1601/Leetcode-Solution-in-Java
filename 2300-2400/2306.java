class Solution {
    public long distinctNames(String[] ideas) {
        long res = 0;
        HashMap<Character, HashMap<String, Boolean>> hm = new HashMap<>();
        ArrayList<Character> characters = new ArrayList<>();
        for (String idea : ideas) {
            if (!hm.containsKey(idea.charAt(0))) {
                hm.put(idea.charAt(0), new HashMap<>());
                characters.add(idea.charAt(0));
            }
            hm.get(idea.charAt(0)).put(idea, true);
        }
        for (int i = 0; i < characters.size(); i++) {
            int count = 0;
            for (int j = i + 1; j < characters.size(); j++) {
                int duplicateFound = 0;
                for (String str : hm.get(characters.get(i)).keySet()) {
                    String swap = characters.get(j) + str.substring(1);
                    if (!hm.get(characters.get(j)).containsKey(swap)) {
                        count += hm.get(characters.get(j)).size();
                    } else {
                        duplicateFound++;
                    }
                }
                count -= (hm.get(characters.get(i)).size() - duplicateFound) * duplicateFound;
            }
            res += count;
        }
        return res * 2;
    }
}
