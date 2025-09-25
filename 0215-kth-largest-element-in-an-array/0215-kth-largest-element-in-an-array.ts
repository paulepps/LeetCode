class MyMinHeap {
  public heap: number[];
  constructor() {
    this.heap = [];
  }

  parent(i) { return Math.floor((i - 1) / 2); }
  left(i) { return 2 * i + 1; }
  right(i) { return 2 * i + 2; }

  swap(i, j) {
    [this.heap[i], this.heap[j]] = [this.heap[j], this.heap[i]];
  }

  push(val) {
    this.heap.push(val);
    this.heapifyUp(this.heap.length - 1);
  }

  heapifyUp(i) {
    while (i > 0 && this.heap[this.parent(i)] > this.heap[i]) {
      this.swap(i, this.parent(i));
      i = this.parent(i);
    }
  }

  pop() {
    if (this.heap.length === 0) return null;
    if (this.heap.length === 1) return this.heap.pop();
    const root = this.heap[0];
    this.heap[0] = this.heap.pop();
    this.heapifyDown(0);
    return root;
  }

  heapifyDown(i) {
    let smallest = i;
    const left = this.left(i);
    const right = this.right(i);

    if (left < this.heap.length && this.heap[left] < this.heap[smallest]) {
      smallest = left;
    }
    if (right < this.heap.length && this.heap[right] < this.heap[smallest]) {
      smallest = right;
    }
    if (smallest !== i) {
      this.swap(i, smallest);
      this.heapifyDown(smallest);
    }
  }

  peek() {
    return this.heap.length > 0 ? this.heap[0] : null;
  }

  size() {
    return this.heap.length;
  }
}

function findKthLargest(nums: number[], k: number): number {
    const heap = new MyMinHeap();

    for (const num of nums) {
        if (heap.size() < k) {
        heap.push(num);
        } else if (num > heap.peek()) {
        heap.pop();
        heap.push(num);
        }
    }

    return heap.peek();
}
