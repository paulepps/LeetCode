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
}

function kClosest(points: number[][], k: number): number[][] {
    const heap = new MyMinHeap<number>();

    for (let i = 0; i < points.length; i++) {
        const [x, y] = points[i];
        const dist = x * x + y * y;
        heap.push(dist, i);
    }

    const result: number[][] = [];
    for (let i = 0; i < k; i++) {
        const popped = heap.pop();
        if (popped) {
            result.push(points[popped.value]);
        }
    }

    return result;
}
