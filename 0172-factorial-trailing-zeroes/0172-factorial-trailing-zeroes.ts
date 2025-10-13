function trailingZeroes(n: number): number {
    let count = 0;
    let i = 5;
    while (Math.floor(n / i) >= 1) {
        count += Math.floor(n / i);
        i *= 5;
    }
    return count;
}
