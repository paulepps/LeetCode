function longestPalindrome(s: string): string {
    const n = s.length;
    if (n < 2) return s;

    let start = 0;
    let maxLen = 1;

    const expandAroundCenter = (left: number, right: number): void => {
        while (left >= 0 && right < n && s[left] === s[right]) {
            if (right - left + 1 > maxLen) {
                start = left;
                maxLen = right - left + 1;
            }
            left--;
            right++;
        }
    };

    for (let i = 0; i < n; i++) {
        expandAroundCenter(i, i);     // Odd-length palindrome
        expandAroundCenter(i, i + 1); // Even-length palindrome
    }

    return s.slice(start, start + maxLen);
}

