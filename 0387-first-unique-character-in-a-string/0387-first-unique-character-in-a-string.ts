function firstUniqChar(s: string): number {
    const charCount: Record<string, number> = {};

    for (const c of s) {
        charCount[c] = (charCount[c] || 0) + 1;
    }

    for (let i = 0; i < s.length; i++) {
        if (charCount[s[i]] === 1) {
            return i;
        }
    }

    return -1;
}
