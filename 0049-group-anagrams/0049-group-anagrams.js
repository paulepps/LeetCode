/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
            let map = new Map();

        // loop over all words
        for (let i = 0; i < strs.length; i++) {

            // convert to char array, sort and
            // then re-convert to string
            let word = strs[i];
            let newWord = word.split('').sort().join('');

            // calculate hashcode of string
            // after sorting
            if (map.has(newWord)) {

                map.get(newWord).push(word);
            }
            else {

                // This is the first time we are
                // adding a word for a specific
                // hashcode
                let words = [];
                words.push(word);
                map.set(newWord, words);
            }
        }
        // print all the values where size is > 1
        // If you want to print non-anagrams,
        // just print the values having size = 1
        let ans = [];
        for (let values of map.values()) {
            ans.push(values);
        }
        return ans;

};