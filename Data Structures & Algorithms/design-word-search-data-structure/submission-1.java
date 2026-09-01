class WordDictionary {
    class TrieNode {
        boolean isWord;
        HashMap<Character,TrieNode> childs;
        TrieNode(){
            childs = new HashMap<>();
        }
    }
    
    TrieNode root;
    public WordDictionary() {
        root  = new TrieNode();

    }

    public void addWord(String word) {
        TrieNode temp = root;
        for(char c:word.toCharArray()){
            if(!temp.childs.containsKey(c)){
                temp.childs.put(c,new TrieNode());
            }
            temp = temp.childs.get(c);
        }
        temp.isWord = true;

    }

    public boolean search(String word, int idx, TrieNode node){
        if(idx==word.length()){
            return node.isWord;
        }
         char c = word.charAt(idx);

        // Normal character
        if (c != '.') {
            if(node.childs.containsKey(c)){
                TrieNode next = node.childs.get(c);
                return search(word, idx + 1, next);
            } else {
                return false;
            }
            
        }

        // '.': try every possible character
        for (TrieNode child : node.childs.values()) {
            if (search(word, idx + 1, child)) {
                return true;
            }
        }

        return false;
    }

    public boolean search(String word) {
        return  search(word,0,root);
    }
}
