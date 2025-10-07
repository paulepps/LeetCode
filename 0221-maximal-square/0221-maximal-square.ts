function maximalSquare(matrix: string[][]): number {
    if (matrix.length === 0 || matrix[0].length === 0) {
        return 0;
    }

    const m: number = matrix.length;
    const n: number = matrix[0].length;

    // dp has an extra row and column (initialized to 0) to avoid boundary checks
    const dp: number[][] = Array.from({ length: m + 1 }, () => new Array(n + 1).fill(0));

    let maxSide = 0;

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (matrix[i][j] === "1") {
                dp[i + 1][j + 1] = Math.min(
                    dp[i][j + 1],   // top
                    dp[i + 1][j],   // left
                    dp[i][j]        // top-left
                ) + 1;
                maxSide = Math.max(maxSide, dp[i + 1][j + 1]);
            }
        }
    }

    return maxSide * maxSide;
}

