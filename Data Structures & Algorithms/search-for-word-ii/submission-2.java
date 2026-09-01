class Solution {
    class TrieNode {
        HashMap<Character,TrieNode> children;
        boolean isWord;
        int refs;
        public TrieNode(){
            children = new HashMap<>();
        }
    }
    class Trie {
        TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
        public void addWord(String word){
            TrieNode node = root;
            node.refs++;
            for(char c: word.toCharArray()){
                if(!node.children.containsKey(c))node.children.put(c,new TrieNode());
                node = node.children.get(c);
                node.refs++;
            }
            node.isWord = true;
        }
    }
    public int dfs(char[][]board,int i, int j,String word,TrieNode node,List<String> result){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]=='#' || !node.children.containsKey(board[i][j]) ){
            return 0;
        }

        char c = board[i][j];
        board[i][j] = '#';
        TrieNode child = node.children.get(c);
        word = word + c;
        int found = 0;
        if(child.isWord) {
            result.add(word);
            child.isWord = false;
            found++;
        }
        found+=dfs(board,i+1,j,word,child,result);
        found+=dfs(board,i-1,j,word,child,result);
        found+=dfs(board,i,j+1,word,child,result);
        found+=dfs(board,i,j-1,word,child,result);
        board[i][j] = c;
        child.refs -= found;
        if(child.refs==0){
            node.children.put(c,new TrieNode());
        }
        return found;

    }
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word:words){
            trie.addWord(word);
        }
        List<String> result = new ArrayList<>();

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                trie.root.refs-=dfs(board,i,j,"",trie.root,result);
            }
        }
        return result;
        
    }
}
