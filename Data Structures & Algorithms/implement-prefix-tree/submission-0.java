class TreeNode {
   HashMap<Character,TreeNode> childrens;
   boolean isWord;
   TreeNode(){
    childrens = new HashMap<>();
    isWord = false;
   } 
}
class PrefixTree {
    TreeNode root;

    public PrefixTree() {
        root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode node = root;
        for(char c: word.toCharArray()){
            if(!node.childrens.containsKey(c)){
                node.childrens.put(c,new TreeNode());
            }
            node = node.childrens.get(c);
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        TreeNode node = root;
        for(char c: word.toCharArray()){
            if(!node.childrens.containsKey(c)){
                return false;
            }
            node = node.childrens.get(c);
        }
        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        TreeNode node = root;
        for(char c: prefix.toCharArray()){
            if(!node.childrens.containsKey(c)){
                return false;
            }
            node = node.childrens.get(c);
        }
        return true;
    }
}
