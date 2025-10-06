function numDecodings(s: string): number {
    if (s[0] === '0') {
        return 0;
    }

    const n: number = s.length;
    const dp: number[] = new Array(n + 1).fill(0);

    dp[n] = 1;
    dp[n - 1] = s[n - 1] === '0' ? 0 : 1;

    for (let i = n - 2; i >= 0; i--) {
        if (s[i] === '0') {
            dp[i] = 0;
            continue;
        }

        dp[i] = dp[i + 1];

        const twoDigitNum: number = parseInt(s.substring(i, i + 2));
        if (twoDigitNum >= 10 && twoDigitNum <= 26) {
            dp[i] += dp[i + 2];
        }
    }

    return dp[0];
}
