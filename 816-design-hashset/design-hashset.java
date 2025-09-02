class ListNode {
    int key;
    ListNode next;

    ListNode(int key) {
        this.key = key;
        this.next = null;
    }
}

class MyHashSet {
    private ListNode[] set;

    public MyHashSet() {
        set = new ListNode[1000];
    }

    private int hash(int key) {
        return key % 1000;
    }

    public void add(int key) {
        int hash = hash(key);

        if (set[hash] == null) {
            set[hash] = new ListNode(key); 
            return;
        }

        ListNode curr = set[hash];
        while (true) {
            if (curr.key == key) {
                return; 
            }
            if (curr.next == null) {
                break; 
            }
            curr = curr.next;
        }

        curr.next = new ListNode(key); 
    }

    public void remove(int key) {
        int hash = hash(key);
        ListNode curr = set[hash];

        if (curr == null) return;

        if (curr.key == key) {
            set[hash] = curr.next;
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

    public boolean contains(int key) {
        int hash = hash(key);
        ListNode curr = set[hash];

        while (curr != null) {
            if (curr.key == key) {
                return true;
            }
            curr = curr.next;
        }

        return false;
    }
}
