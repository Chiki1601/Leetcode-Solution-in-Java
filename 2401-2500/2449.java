class Solution {
   public long makeSimilar(int[] A, int[] B) {
	Arrays.sort(A); Arrays.sort(B);
	List<Integer> oA = new ArrayList(), eA = new ArrayList(), 
	oB = new ArrayList(), eB = new ArrayList();
	for (int x: A) {
		if (x % 2 == 1) oA.add(x);
		else eA.add(x);
	}
	for (int x: B) {
		if (x % 2 == 1) oB.add(x);
		else eB.add(x);
	}
	long ans = 0;
	for (int i = 0; i < oA.size(); i++)
	  if (oA.get(i) > oB.get(i)) 
		  ans += (oA.get(i) - oB.get(i)) / 2;
	for (int i = 0; i < eA.size(); i++)
	  if (eA.get(i) > eB.get(i)) 
		  ans += (eA.get(i) - eB.get(i)) / 2;
	return ans;
}
}
