class ListNode {
    int key;
    int value;
    ListNode next;
    ListNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class MyHashMap {

    private ListNode[] map;

    public MyHashMap() {
        map = new ListNode[1000];
        for (int i = 0; i < 1000; i++) {
            map[i] = new ListNode(-1, -1); 
        }
    }
    
    public void put(int key, int value) {
        int hash = hash(key);
        ListNode curr = map[hash];

        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next.value = value; 
                return;
            }
            curr = curr.next;
        }

        curr.next = new ListNode(key, value); 
    }
    
    public int get(int key) {
        int hash = hash(key);
        ListNode curr = map[hash].next;

        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }
            curr = curr.next;
        }

        return -1;
    }
    
    public void remove(int key) {
        int hash = hash(key);
        ListNode curr = map[hash];

        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next; 
                return; 
            }
            curr = curr.next;
        }
    }

    private int hash(int key) {
        return key % 1000;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
