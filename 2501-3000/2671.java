class FrequencyTracker {
  int[] map, freq;

  public FrequencyTracker() {
    map = new int[100001];
    freq = new int[100001];
  }

  public void add(int number) {
    freq[map[number]++]--;
    freq[map[number]]++;
  }

  public void deleteOne(int number) {
    if (map[number] > 0) {
      freq[map[number]--]--;
      freq[map[number]]++;
    }
  }

  public boolean hasFrequency(int frequency) {
    return freq[frequency] > 0;
  }
}
