class MyMinHeap<T> {
    private heap: { key: number; value: T }[] = [];

    private parent(i: number): number { return Math.floor((i - 1) / 2); }
    private left(i: number): number { return 2 * i + 1; }
    private right(i: number): number { return 2 * i + 2; }

    private swap(i: number, j: number): void {
        [this.heap[i], this.heap[j]] = [this.heap[j], this.heap[i]];
    }

    push(key: number, value: T): void {
        this.heap.push({ key, value });
        this.heapifyUp(this.heap.length - 1);
    }

    private heapifyUp(i: number): void {
        while (i > 0 && this.heap[this.parent(i)].key > this.heap[i].key) {
            this.swap(i, this.parent(i));
            i = this.parent(i);
        }
    }

    pop(): { key: number; value: T } | null {
        if (this.heap.length === 0) return null;
        if (this.heap.length === 1) return this.heap.pop()!;

        const root = this.heap[0];
        this.heap[0] = this.heap.pop()!;
        this.heapifyDown(0);
        return root;
    }

    private heapifyDown(i: number): void {
        let smallest = i;
        const left = this.left(i);
        const right = this.right(i);

        if (left < this.heap.length && this.heap[left].key < this.heap[smallest].key) {
            smallest = left;
        }
        if (right < this.heap.length && this.heap[right].key < this.heap[smallest].key) {
            smallest = right;
        }
        if (smallest !== i) {
            this.swap(i, smallest);
            this.heapifyDown(smallest);
        }
    }

    size(): number {
        return this.heap.length;
    }

    peek(): { key: number; value: T } | null {
        return this.heap.length > 0 ? this.heap[0] : null;
    }

    values(): T[] {
        return this.heap.map(entry => entry.value);
    }
}

function topKFrequent(nums: number[], k: number): number[] {
    // Count frequencies
    const freqMap = new Map<number, number>();
    for (const num of nums) {
        freqMap.set(num, (freqMap.get(num) || 0) + 1);
    }

    // Min-heap of (frequency, number)
    const heap = new MyMinHeap<number>();
    for (const [num, freq] of freqMap.entries()) {
        heap.push(freq, num);
        if (heap.size() > k) {
            heap.pop();
        }
    }

    // Extract elements from heap
    return heap.values();
}
