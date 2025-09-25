class MyMaxHeap {
    private heap;

    constructor() {
        this.heap = [];
    }

    private parent(i) {
        return Math.floor((i - 1) / 2);
    }

    private left(i) {
        return 2 * i + 1;
    }

    private right(i) {
        return 2 * i + 2;
    }

    private swap(i, j) {
        [this.heap[i], this.heap[j]] = [this.heap[j], this.heap[i]];
    }

    push(val) {
        this.heap.push(val);
        this.heapifyUp(this.heap.length - 1);
    }

    private heapifyUp(i) {
        while (i > 0 && this.heap[this.parent(i)] < this.heap[i]) {
            this.swap(i, this.parent(i));
            i = this.parent(i);
        }
    }

    pop() {
        if (this.heap.length === 0) return null;
        if (this.heap.length === 1) return this.heap.pop()!;

        const root = this.heap[0];
        this.heap[0] = this.heap.pop()!;
        this.heapifyDown(0);
        return root;
    }

    private heapifyDown(i) {
        let largest = i;
        const left = this.left(i);
        const right = this.right(i);

        if (left < this.heap.length && this.heap[left] > this.heap[largest]) {
            largest = left;
        }
        if (right < this.heap.length && this.heap[right] > this.heap[largest]) {
            largest = right;
        }
        if (largest !== i) {
            this.swap(i, largest);
            this.heapifyDown(largest);
        }
    }

    peek() {
        return this.heap.length > 0 ? this.heap[0] : null;
    }

    size() {
        return this.heap.length;
    }
}

function lastStoneWeight(stones) {
    const heap = new MyMaxHeap();
    for (const s of stones) {
        heap.push(s);
    }

    while (heap.size() > 1) {
        const y = heap.pop()!; // heaviest
        const x = heap.pop()!; // second heaviest
        if (y !== x) {
            heap.push(y - x);
        }
    }

    return heap.size() === 0 ? 0 : heap.peek()!;
}
