class Solution {
        public boolean isCircularSentence(String sentence) {
        //split sentence into array of words
        String[] arr = sentence.split(" ");
        
        //check for 2nd condition
        if(arr[0].charAt(0) != arr[arr.length - 1].charAt(arr[arr.length - 1].length() - 1)) return false;

        //check for first condition
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i + 1].charAt(0) != arr[i].charAt(arr[i].length() - 1)) return false;
        }
        return true;
    }
}
