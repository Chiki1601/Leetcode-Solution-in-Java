class Solution {
  public long dividePlayers(int[] skill) {
    final int n = skill.length;
    int total = 0;
    int[] count = new int[2001];
    for (int s : skill) {
      total += s;
      count[s]++;
    }

    if (total % (n / 2) != 0) {
      return -1;
    }

    // skill of each team
    final int team = total / (n / 2);
    // number of player
    int seen = 0;
    long chemistry = 0;
    for (int i = 1; i < Math.min(team, 2001); i++) {
      if (count[i] != count[team - i]) {
        return -1;
      }

      if (i == team - i) {
        // player with same skill with even count
        if (count[i] % 2 != 0) {
          return -1;
        }
        chemistry += (long) count[i] / 2 * i * (team - i);
        seen += count[i];
      } else {
        chemistry += (long) count[i] * i * (team - i);
        seen += 2 * count[i];
      }

      count[i] = 0;
      count[team - i] = 0;
    }

    if (seen != n) {
      return -1;
    }

    return chemistry;
  }
}
