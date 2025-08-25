class MyStack {

    private Queue<Integer> queue1;  
    private Queue<Integer> queue2;  

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        if (queue1.isEmpty()) {
            queue1.add(x);
            while (!queue2.isEmpty()) {
                queue1.add(queue2.remove());
            }
        } else {
            queue2.add(x);
            while (!queue1.isEmpty()) {
                queue2.add(queue1.remove());
            }
        }
    }
    
    public int pop() {
        if (!queue1.isEmpty()) {
            return queue1.remove();
        } else {
            return queue2.remove();
        }
    }
    
    public int top() {
        if (!queue1.isEmpty()) {
            return queue1.peek();
        } else {
            return queue2.peek();
        }
    }
    
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */