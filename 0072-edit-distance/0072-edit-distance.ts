function minDistance(word1: string, word2: string): number {
    const s1 = word1;
    const s2 = word2;

    const m = word1.length;
    const n = word2.length;

    // initialize memo with -1
    const memo = Array.from({ length: m + 1 }, () => new Array(n + 1).fill(-1));

    function editDistance(m: number, n: number): number {
        if (m === 0) return n;
        if (n === 0) return m;

        if (memo[m][n] !== -1) {
            return memo[m][n];
        }

        if (s1[m - 1] === s2[n - 1]) {
            memo[m][n] = editDistance(m - 1, n - 1);
        } else {
            const insert = editDistance(m, n - 1);
            const replace = editDistance(m - 1, n - 1);
            const remove = editDistance(m - 1, n);
            memo[m][n] = 1 + Math.min(insert, replace, remove);
        }

        return memo[m][n];
    }
    return editDistance(m, n);
}

