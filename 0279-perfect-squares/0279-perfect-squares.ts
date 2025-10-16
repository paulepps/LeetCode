function numSquares(n: number): number {
    const dp: number[] = new Array(n + 1).fill(Infinity);
    dp[0] = 0;

    let count = 1;
    let sq = count * count;

    while (sq <= n) {
        for (let i = sq; i <= n; i++) {
            dp[i] = Math.min(dp[i - sq] + 1, dp[i]);
        }
        count++;
        sq = count * count;
    }

    return dp[n];
}
