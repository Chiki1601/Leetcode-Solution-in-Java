class Solution {
  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
	int max = Arrays.stream(candies).max().getAsInt();
	List<Boolean> result = new ArrayList<>();
	for (int candy : candies) {
		result.add(candy + extraCandies >= max);
	}
	return result;
 }
}
