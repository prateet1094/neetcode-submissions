class Solution {

    public class TrieNode {
        boolean isWord;
        HashMap<Character,TrieNode> childrens;
        public TrieNode (){
            childrens = new HashMap<>();
            isWord = false;
        }
    }
    public class Trie {
        TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
        public void insert(String word){
            TrieNode node = root;
            for(char c: word.toCharArray()){
                if(!node.childrens.containsKey(c)){
                    node.childrens.put(c,new TrieNode());
                }
                node = node.childrens.get(c);
            }
            node.isWord = true;
        }

        public boolean search(String s,int i,int j){
            TrieNode node = root;
            for(int idx=i;idx<j;idx++){
                if(node.childrens.containsKey(s.charAt(idx))){
                    node = node.childrens.get(s.charAt(idx));
                } else {
                    return false;
                }
            }
            return node.isWord;

        }
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean []dp = new boolean[s.length()+1];
        dp[s.length()] = true;
        Trie trie = new Trie();
        for(String word : wordDict){
            trie.insert(word);
        }
        int maxLen = 0; 
        for (String word : wordDict) { 
            maxLen = Math.max(maxLen, word.length()); 
        }
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i+1;j<=Math.min(s.length(), i + maxLen);j++){
                if(trie.search(s,i,j)){
                    dp[i] = dp[j];
                }
                if(dp[i])break;
            }
        }
        return dp[0];
        
    }
}
