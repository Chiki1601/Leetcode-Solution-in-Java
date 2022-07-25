class Solution {
    /* 
        TC : O(N*M)
        SC : O(1)
    */
    public int numOfStrings(String[] patterns, String word) {
        int result = 0;
        for(int i = 0; i< patterns.length;i++) {
            if(word.indexOf(patterns[i]) >= 0) {
                result ++;
            }
        }
        return result;
    }
    
    
    
    
    
    class Trie {
        Node root = new Node('/');
        int maxWordLength = 0;
        private void addWord (String word){
            Node cur = root; 
            this.maxWordLength = Math.max(maxWordLength, word.length());
            for(int i =0 ;i<word.length();i++) {
                addNode(cur,word.charAt(i));
                cur = cur.getChild(word.charAt(i));
            }
            if(cur != root) {
                
            cur.cnt ++;
            }
        }
        private void addNode (Node parent, char letter) {
            if(parent.getChild(letter)==null ) {
                parent.addChild(new Node(letter));
            }
        }
        private int getIdx(String s, int i ) {
            return s.charAt(i) - 'a';
        }
        private void getWordCnt( String s,int from , int[] result ) {
            int cnt = 0;
            Node cur = root; 
            int lastIdx = from;
            for(int i = 0; i+from < s.length();i++) {
                cur = cur.getChild(s.charAt(from+i));
                if(cur==null) {
                    break;
                }
                cnt +=cur.cnt;
                lastIdx ++;                    
            }
            result [0] = cnt;
            result [1]=lastIdx;
            
        }
    }   
    class Node {
        char letter ;
        int cnt = 0;
        Node (char letter) {
            this.letter = letter;
        }   
        private int getIdx() {
            return letter - 'a';
        }
        private Node getChild(char letter) {
            return this.children[letter - 'a'];
        }
        private void addChild(Node node) {
            this.children[node.getIdx()] = node;
        }
        
        Node[] children = new Node[26];        
    }
    
     
    
    public int numOfStrings001(String[] patterns, String word) {
        Trie trie = new Trie();
        int result = 0;
        for( int patternsIdx = 0 ; patternsIdx < patterns.length ; patternsIdx++) {
            trie.addWord(patterns[patternsIdx]);
        }
        int idx =0;
        int[] trieResult = new int[2];
        while(idx <word.length() ) {
            trieResult[0] = 0;
            trie.getWordCnt(word,idx,trieResult);
            result +=trieResult[0];
            idx++;
            
        }
            
        return result;
    }
    
}
