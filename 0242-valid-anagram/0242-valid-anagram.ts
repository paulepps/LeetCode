function isAnagram(s: string, t: string): boolean {
    if (s.length !== t.length) {
        return false;
    }

    const count: number[] = new Array(26).fill(0);

    for (const c of s) {
        count[c.charCodeAt(0) - 'a'.charCodeAt(0)]++;
    }

    for (const c of t) {
        count[c.charCodeAt(0) - 'a'.charCodeAt(0)]--;
    }

    for (const val of count) {
        if (val !== 0) {
            return false;
        }
    }

    return true;
}
