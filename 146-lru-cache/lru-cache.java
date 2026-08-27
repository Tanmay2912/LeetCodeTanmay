import java.util.HashMap;

class LRUCache {

    final int size;
    HashMap<Integer, Node> map;

    public Node head;
    public Node tail;

    static class Node {
        public int key;
        public int value;
        public Node prev;
        public Node next;

        Node(int key, int value, Node prev, Node next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        // Constructor for dummy head/tail nodes
        Node() {
        }
    }

    public void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insertAfterHead(Node node) {
        Node nextNode = head.next;

        head.next = node;
        nextNode.prev = node;

        node.prev = head;
        node.next = nextNode;
    }

    public LRUCache(int capacity) {
        size = capacity;

        map = new HashMap<>(size);

        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        int value = node.value;

        deleteNode(node);
        insertAfterHead(node);

        return value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {

            Node node = map.get(key);

            node.value = value;

            deleteNode(node);
            insertAfterHead(node);

            return;
        }

        if (map.size() == size) {

            Node node = tail.prev;

            map.remove(node.key);

            deleteNode(node);
        }

        Node newNode = new Node(key, value, null, null);

        map.put(key, newNode);

        insertAfterHead(newNode);
    }
}