class MyMaxHeap {
    private heap: number[];

    constructor() {
        this.heap = [];
    }

    private parent(i: number): number {
        return Math.floor((i - 1) / 2);
    }

    private left(i: number): number {
        return 2 * i + 1;
    }

    private right(i: number): number {
        return 2 * i + 2;
    }

    private swap(i: number, j: number): void {
        [this.heap[i], this.heap[j]] = [this.heap[j], this.heap[i]];
    }

    push(val: number): void {
        this.heap.push(val);
        this.heapifyUp(this.heap.length - 1);
    }

    private heapifyUp(i: number): void {
        while (i > 0 && this.heap[this.parent(i)] < this.heap[i]) {
            this.swap(i, this.parent(i));
            i = this.parent(i);
        }
    }

    pop(): number | null {
        if (this.heap.length === 0) return null;
        if (this.heap.length === 1) return this.heap.pop()!;

        const root = this.heap[0];
        this.heap[0] = this.heap.pop()!;
        this.heapifyDown(0);
        return root;
    }

    private heapifyDown(i: number): void {
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

    peek(): number | null {
        return this.heap.length > 0 ? this.heap[0] : null;
    }

    size(): number {
        return this.heap.length;
    }
}

function lastStoneWeight(stones: number[]): number {
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
