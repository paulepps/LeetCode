function isPalindrome(s: string): boolean {
    const strClean = s.toLowerCase().replace(/[^a-z0-9]/g, '');
    if (!strClean) {
        return true;
    }
    const reversed = strClean.split('').reverse().join('');
    return strClean === reversed;
}
