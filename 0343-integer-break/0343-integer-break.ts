function integerBreak(n: number): number {
    const dp: number[] = new Array(n + 1).fill(0);
    dp[1] = 1;

    for (let i = 2; i <= n; i++) {
        let maxProduct = 0;
        for (let j = 1; j < i; j++) {
            maxProduct = Math.max(
                maxProduct,
                Math.max(j * (i - j), j * dp[i - j])
            );
        }
        dp[i] = maxProduct;
    }

    return dp[n];
}
