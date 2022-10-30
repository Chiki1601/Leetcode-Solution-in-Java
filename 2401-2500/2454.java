class Solution {
     public int[] secondGreaterElement(int[] A) {
        int n = A.length,  res[] = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>(), tmp = new Stack<>();
        for (int i=0; i < n; i++) {
            while (!s2.empty() && A[s2.peek()] < A[i])
                res[s2.pop()] = A[i];
            while (!s1.empty() && A[s1.peek()] < A[i])
                tmp.push(s1.pop());
            while (!tmp.empty())
                s2.push(tmp.pop());
            s1.push(i);
        }
        return res;
    }
}
