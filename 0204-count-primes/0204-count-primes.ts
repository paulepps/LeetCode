function countPrimes(n: number): number {
    if (n <= 2) {
        return 0;
    }

    const prime: boolean[] = new Array(n).fill(true);
    prime[0] = false;
    prime[1] = false;

    let p = 2;
    while (p * p <= n) {
        if (prime[p]) {
            for (let i = p * p; i < n; i += p) {
                prime[i] = false;
            }
        }
        p++;
    }

    let count = 0;
    for (const isPrime of prime) {
        if (isPrime) {
            count++;
        }
    }

    return count;
}
