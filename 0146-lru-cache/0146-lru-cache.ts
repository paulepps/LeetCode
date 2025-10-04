class Node {
  key: number;
  value: number;
  prev: Node | null;
  next: Node | null;

  constructor(key: number, value: number) {
    this.key = key;
    this.value = value;
    this.prev = null;
    this.next = null;
  }
}

class LRUCache {
  private capacity: number;
  private cacheMap: Map<number, Node>;
  private head: Node;
  private tail: Node;

  constructor(capacity: number) {
    this.capacity = capacity;
    this.cacheMap = new Map();
    this.head = new Node(-1, -1);
    this.tail = new Node(-1, -1);
    this.head.next = this.tail;
    this.tail.prev = this.head;
  }

  get(key: number): number {
    if (!this.cacheMap.has(key)) {
      return -1;
    }

    const node = this.cacheMap.get(key)!;
    this.remove(node);
    this.add(node);
    return node.value;
  }

  put(key: number, value: number): void {
    if (this.cacheMap.has(key)) {
      this.remove(this.cacheMap.get(key)!);
    }

    const node = new Node(key, value);
    this.cacheMap.set(key, node);
    this.add(node);

    if (this.cacheMap.size > this.capacity) {
      const nodeToDelete = this.tail.prev!;
      this.remove(nodeToDelete);
      this.cacheMap.delete(nodeToDelete.key);
    }
  }

  private remove(node: Node): void {
    const prevNode = node.prev!;
    const nextNode = node.next!;
    prevNode.next = nextNode;
    nextNode.prev = prevNode;
  }

  private add(node: Node): void {
    const nextNode = this.head.next!;
    this.head.next = node;
    node.prev = this.head;
    node.next = nextNode;
    nextNode.prev = node;
  }
}
