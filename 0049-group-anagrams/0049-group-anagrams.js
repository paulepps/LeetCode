/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    const anagramsMap = {};

    for (const word of strs) {
        const sortedWord = word.split('').sort().join('');
        if (!anagramsMap[sortedWord]) {
            anagramsMap[sortedWord] = [];
        }
        anagramsMap[sortedWord].push(word);
    }

    return Object.values(anagramsMap);
};
