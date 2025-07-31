/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
        const anagramsMap = new Map();

        for (const str of strs) {
            const arr = str.split("");
            arr.sort();

            const sortedStr = arr.join("");

            let words = anagramsMap.get(sortedStr);

            if (words) {
                words.push(str);
            } else {
                words = [str];
            }

            anagramsMap.set(sortedStr, words);
        }

        return [...anagramsMap.values()];
};
