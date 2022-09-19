// solution 1

class Solution {
  public int smallestEvenMultiple(int n) {
    return n * (n % 2 + 1);
  }
}



//solution 2
class Solution {

    public int smallestEvenMultiple(int n) {

        if(n%2==0) return n;

        return 2*n;

    }

}
