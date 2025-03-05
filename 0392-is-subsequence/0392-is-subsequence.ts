function isSubsequence(s: string, t: string): boolean {
        let n = s.length;
        let m = t.length;

//        if (n > m) return false;

        let i = 0;
        let j = 0;

        while (i < n && j < m) {
            if (s[i] == t[j]) {
                i++;
            }
            j++;
        }
        return i == n;
};