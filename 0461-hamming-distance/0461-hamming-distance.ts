function hammingDistance(x: number, y: number): number {
    let xor = x ^ y;
    let count = 0;

    while (xor !== 0) {
        xor &= (xor - 1); // clear the lowest set bit
        count++;
    }

    return count;
}
