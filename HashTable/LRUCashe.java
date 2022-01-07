// Link: https://leetcode.com/problems/lru-cache/
// Difficulty: Medium
// Time complexity: O(1)
// Space complexity: O(n)
// test
class LRUCache {
    
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }
    
     private void addNode(Node n) {
       n.prev = head;
       n.next = head.next;
       head.next.prev = n;
       head.next = n;
    }

    private void removeNode(Node n) {
       n.prev.next = n.next;
       n.next.prev = n.prev;
    }

    private void moveToHead(Node n) {
        removeNode(n);
        addNode(n);
    }

    private Node popTail() {
       Node ret = tail.prev;
       removeNode(ret);
       return ret;
    }
    
    int capacity;
    int size;
    Map<Integer, Node> cache = new HashMap<>();
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        Node ret = cache.get(key);
        if (ret == null) {
            return -1;
        }
        moveToHead(ret);
        return ret.value;
    }
    
    public void put(int key, int value) {
        Node n = cache.get(key);

        // node alr exists in cache
        if (n != null) {
            n.value = value;
            moveToHead(n);
        }
        
        // node does not exist in cache, so must be added
        else {
            if (size == capacity) {
                Node removed = popTail();
                cache.remove(removed.key);
                size--;
            }
            Node added = new Node();
            added.key = key;
            added.value = value;
            addNode(added);
            cache.put(key, added);
            size++;
        }

    }
    
}
