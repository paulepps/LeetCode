function uniquePaths(m: number, n: number): number {
    const dp: number[] = new Array(n).fill(0);
    dp[0] = 1;

    for (let row = 0; row < m; row++) {
        for (let col = 0; col < n; col++) {
            if (col > 0) {
                dp[col] += dp[col - 1];
            }
        }
    }

    return dp[n - 1];
}
