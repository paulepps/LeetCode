class MyCircularQueue {

    private int[] qArray;
    private int front;
    private int rear;
    private int size;

    public MyCircularQueue(int k) {
        qArray = new int[k];
        front = -1;
        rear = -1;
        size = 0;     
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;

        if (front == -1) front = 0;

        rear = (rear + 1) % qArray.length;
        qArray[rear] = value;
        size++;

        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;

        front = (front + 1) % qArray.length;
        size--;

        return true;
    }
    
    public int Front() {
        if (isEmpty())
            return -1;
        else
            return qArray[front];
    }
    
    public int Rear() {
        if (isEmpty())
            return -1;
        else
            return qArray[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == qArray.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */