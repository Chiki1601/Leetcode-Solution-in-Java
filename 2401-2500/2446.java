class Solution {
     public boolean haveConflict(String[] e1, String[] e2) {
        return e1[0].compareTo(e2[1]) <= 0 && e2[0].compareTo(e1[1]) <= 0;
    }
}
