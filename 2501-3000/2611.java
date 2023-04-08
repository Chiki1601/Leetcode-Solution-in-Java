class Solution {
  public int miceAndCheese(int[] reward1, int[] reward2, int k) {
    final int n = reward1.length;
    int points = 0;
    for (int i = 0; i < n; i++) {
      reward1[i] -= reward2[i];
      points += reward2[i];
    }

    // pick top k
    Arrays.sort(reward1);
    for (int i = 0; i < k; i++) {
      points += reward1[n - 1 - i];
    }

    return points;
  }
}
