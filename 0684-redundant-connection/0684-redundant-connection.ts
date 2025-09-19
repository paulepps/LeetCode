class UnionFind {
    private parent: number[];
    private rank: number[];

    constructor(n: number) {
        // Using n+1 so we can index from 1 to n directly
        this.parent = Array.from({ length: n + 1 }, (_, i) => i);
        this.rank = new Array(n + 1).fill(0);
    }

    find(x: number): number {
        if (this.parent[x] !== x) {
            this.parent[x] = this.find(this.parent[x]); // Path compression
        }
        return this.parent[x];
    }

    union(x: number, y: number): boolean {
        const px = this.find(x);
        const py = this.find(y);

        if (px === py) {
            return false; // Cycle detected
        }

        if (this.rank[px] < this.rank[py]) {
            this.parent[px] = py;
        } else if (this.rank[px] > this.rank[py]) {
            this.parent[py] = px;
        } else {
            this.parent[py] = px;
            this.rank[px]++;
        }
        return true;
    }
}

function findRedundantConnection(edges: number[][]): number[] {
    const n = edges.length;
    const uf = new UnionFind(n);

    for (const [x, y] of edges) {
        if (!uf.union(x, y)) {
            return [x, y];
        }
    }

    return [];
}
