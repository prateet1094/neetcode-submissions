class LRUCache {

    class NodeList{
        int val;
        int key;
        NodeList next;
        NodeList prev;
        NodeList(int key,int val){
            this.val = val;
            this.key = key;
        }
    }
    HashMap<Integer,NodeList> map ;
    int capacity;
    NodeList head;
    NodeList tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer,NodeList>();
        head = new NodeList(-1,-1);
        tail = new NodeList(-1,-1);

        head.next = tail;
        tail.prev = head;
    }

    public void insertAtTail(NodeList node){
        node.next = tail;
        node.prev = tail.prev;

        tail.prev.next = node;
        tail.prev = node;
    }

    public void delete(NodeList node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public int get(int key) {
        int result = -1;
        if(map.containsKey(key)){
            NodeList  node = map.get(key);
            delete(node);
            insertAtTail(node);
            result = node.val;
        }
        return result;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            delete(map.get(key));
            map.remove(key);
        }
        NodeList n = new NodeList(key,value);
        insertAtTail(n);
        map.put(key, n);  

        if(map.size()>this.capacity)  {
            NodeList lru = head.next;
            delete(lru);
            map.remove(lru.key);
        }     
    }
}
