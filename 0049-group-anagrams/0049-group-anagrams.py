from collections import defaultdict
from typing import List

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagrams_map = defaultdict(list)

        for word in strs:
            sorted_word = ''.join(sorted(word))
            anagrams_map[sorted_word].append(word)

        return list(anagrams_map.values())
