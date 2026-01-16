class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        // Move all elements from s1 to s2
        while(!s1.isEmpty()) {
            s2.add(s1.pop());
        }
        // Add new element to s1
        s1.add(x);
        // Move back all elements from s2 to s1
        while(!s2.isEmpty()) {
            s1.add(s2.pop());
        }
    }
    
    public int pop() {
        return s1.pop();
    }
    
    public int peek() {
        return s1.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
