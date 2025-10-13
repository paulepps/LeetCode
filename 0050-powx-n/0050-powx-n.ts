function myPow(x: number, n: number): number {
    if (n === 0) {
        return 1.0;
    }
    if (n < 0) {
        return 1 / myPow(x, -n);
    }
    if (n % 2 === 1) {
        return x * myPow(x, n - 1);
    }
    return myPow(x * x, Math.floor(n / 2));
}
