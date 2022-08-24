class Solution {
  public int[] twoSum(int[] numbers, int target) {
      int slow = 0, fast = numbers.length - 1;
      while(slow < fast){
          int sum = numbers[slow] + numbers[fast];
          if(sum == target) return new int[]{slow + 1, fast + 1};
          else if(sum < target) slow++;
          else fast--;
      }
      return new int[]{-1, -1};
  }
}
