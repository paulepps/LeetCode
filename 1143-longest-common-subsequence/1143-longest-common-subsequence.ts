function longestCommonSubsequence(text1: string, text2: string): number {

    function lcsRec(text1: string, text2: string, m: number, n: number, memo: number[][]): number {
        if (m === 0 || n === 0) {
            return 0;
        }

        if (memo[m][n] !== -1) {
            return memo[m][n];
        }

        if (text1[m - 1] === text2[n - 1]) {
            memo[m][n] = 1 + lcsRec(text1, text2, m - 1, n - 1, memo);
        } else {
            memo[m][n] = Math.max(
                lcsRec(text1, text2, m, n - 1, memo),
                lcsRec(text1, text2, m - 1, n, memo)
            );
        }

        return memo[m][n];
    }

    const m = text1.length;
    const n = text2.length;

    // initialize memo with -1
    const memo: number[][] = Array.from({ length: m + 1 }, () => Array(n + 1).fill(-1));

    return lcsRec(text1, text2, m, n, memo);
}

