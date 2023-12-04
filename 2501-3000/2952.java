class Solution {

	public int countCompleteSubstrings(String word, int k) {
		int count = 0;
		for (int i = 1; i <= 26; i++) {
			count += countCompleteSubstrings(word, k, 0, i * k);
		}
		return count;
	}

	private int countCompleteSubstrings(String word, int k, int start, int length) {
		if (word.length() - start < length) {
			return 0;
		}
		int map[] = new int[26], count = 0, sum = 0;
		for (int i = start; i < word.length(); i++) {
			if (i > start && Math.abs(word.charAt(i) - word.charAt(i - 1)) > 2) {
				return sum + countCompleteSubstrings(word, k, i, length);
			}
			count += map[word.charAt(i) - 'a'] == k - 1 ? 1 : 0;
			count -= map[word.charAt(i) - 'a']++ == k ? 1 : 0;
			if (i >= start + length - 1) {
				sum += count == length / k ? 1 : 0;
				count += map[word.charAt(i - length + 1) - 'a'] == k + 1 ? 1 : 0;
				count -= map[word.charAt(i - length + 1) - 'a']-- == k ? 1 : 0;
			}
		}
		return sum;
	}
}
