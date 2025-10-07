function longestPalindromeSubseq(s: string): number {
    const n: number = s.length;
    const dp: number[][] = Array.from({ length: n }, () => new Array(n).fill(0));

    // every single character is a palindrome of length 1
    for (let i = 0; i < n; i++) {
        dp[i][i] = 1;
    }

    // check all substring lengths starting from 2
    for (let length = 2; length <= n; length++) {
        for (let i = 0; i <= n - length; i++) {
            const j = i + length - 1;
            if (s[i] === s[j]) {
                dp[i][j] = 2 + (j - i > 1 ? dp[i + 1][j - 1] : 0);
            } else {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
    }

    return dp[0][n - 1];
}
