class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if not needle:
            return 0

        i, j = 0, 0
        hay_len = len(haystack)
        needle_len = len(needle)

        while i + j < hay_len:
            if haystack[i + j] == needle[j]:
                if j == needle_len - 1:
                    return i
                j += 1
            else:
                i += 1
                if j > 0 and haystack[i:i + j] == needle[:j]:
                    j -= 1
                else:
                    j = 0

        return -1
