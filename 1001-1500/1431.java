class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = Arrays.stream(candies).max().getAsInt();
        for (int i = 0; i < candies.length; i++) {
            candies[i] = candies[i] + extraCandies >= maxCandies;
        }
        return Arrays.stream(candies).mapToObj(b -> b == 1).collect(Collectors.toList());
    }
}
