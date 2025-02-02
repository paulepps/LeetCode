function canConstruct(ransomNote: string, magazine: string): boolean {
    if (magazine.length < ransomNote.length) return false;

    const count: number[] = new Array(26).fill(0);

    for (const c of magazine) {
        const idx = c.charCodeAt(0) - 'a'.charCodeAt(0);
        count[idx] += 1;
    }
    for (const c of ransomNote) {
        const idx = c.charCodeAt(0) - 'a'.charCodeAt(0);
        if (count[idx] == 0) 
            return false;
        count[idx] -= 1;
    }
    return true;    
};