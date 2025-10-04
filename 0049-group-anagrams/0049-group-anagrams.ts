function groupAnagrams(strs: string[]): string[][] {
    const anagramsMap: { [key: string]: string[] } = {};

    for (const word of strs) {
        const sortedWord = word.split('').sort().join('');
        if (!anagramsMap[sortedWord]) {
            anagramsMap[sortedWord] = [];
        }
        anagramsMap[sortedWord].push(word);
    }

    return Object.values(anagramsMap);
}
