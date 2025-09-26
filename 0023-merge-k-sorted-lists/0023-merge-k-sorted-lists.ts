/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */

// A simple MinHeap implementation for (val, index, node)
class MyMinHeap {
    private heap: { key: number; index: number; node: ListNode }[] = [];

    private parent(i: number): number { return Math.floor((i - 1) / 2); }
    private left(i: number): number { return 2 * i + 1; }
    private right(i: number): number { return 2 * i + 2; }

    private swap(i: number, j: number): void {
        [this.heap[i], this.heap[j]] = [this.heap[j], this.heap[i]];
    }

    push(key: number, index: number, node: ListNode): void {
        this.heap.push({ key, index, node });
        this.heapifyUp(this.heap.length - 1);
    }

    private heapifyUp(i: number): void {
        while (i > 0 && this.heap[this.parent(i)].key > this.heap[i].key) {
            this.swap(i, this.parent(i));
            i = this.parent(i);
        }
    }

    pop(): { key: number; index: number; node: ListNode } | null {
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

function mergeKLists(lists: Array<ListNode | null>): ListNode | null {
    const heap = new MyMinHeap();

    // Initialize heap with (value, index, node)
    for (let i = 0; i < lists.length; i++) {
        const node = lists[i];
        if (node) {
            heap.push(node.val, i, node);
        }
    }

    const dummy = new ListNode(0);
    let current = dummy;

    while (heap.size() > 0) {
        const popped = heap.pop()!;
        const { node, index } = popped;

        current.next = node;
        current = current.next;

        if (node.next) {
            heap.push(node.next.val, index, node.next);
        }
    }

    return dummy.next;
}
