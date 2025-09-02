class ListNode {
    int key, value;
    ListNode next;

    ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class MyHashMap {
    private ListNode[] map;

    public MyHashMap() {
        map = new ListNode[1000]; 
    }

    private int hash(int key) {
        return key % 1000; 
    }

    public void put(int key, int value) {
        int hash = hash(key);

        if (map[hash] == null) {
            map[hash] = new ListNode(key, value);
            return;
        }

        ListNode curr = map[hash];
        while (true) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            if (curr.next == null) break; 
            curr = curr.next;
        }

        curr.next = new ListNode(key, value);
    }

    public int get(int key) {
        int hash = hash(key);
        ListNode curr = map[hash];

        while (curr != null) {
            if (curr.key == key) return curr.value;
            curr = curr.next;
        }
        return -1; 
    }

    public void remove(int key) {
        int hash = hash(key);
        ListNode curr = map[hash];

        if (curr == null) return;

        if (curr.key == key) {
            map[hash] = curr.next;
            return;
        }

        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }
}
