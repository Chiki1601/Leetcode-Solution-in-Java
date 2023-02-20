class Solution {
    public int minImpossibleOR(int[] A) {
        Set<Integer> s = new HashSet<>();
        for (int a : A)
            s.add(a);
        int a = 1;
        while (s.contains(a))
            a <<= 1;
        return a;
    }
}
