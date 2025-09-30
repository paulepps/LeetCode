function strStr(haystack: string, needle: string): number {
    if (needle.length === 0) return 0;

    let i = 0, j = 0;
    const hayLen = haystack.length;
    const needleLen = needle.length;

    while (i + j < hayLen) {
        if (haystack[i + j] === needle[j]) {
            if (j === needleLen - 1) return i;
            j++;
        } else {
            i++;
            const haySlice = haystack.slice(i, i + j);
            const needleSlice = needle.slice(0, j);
            if (j > 0 && haySlice === needleSlice) {
                j--;
            } else {
                j = 0;
            }
        }
    }

    return -1;
}
