class Solution:
    def longestPalindrome(self, s: str) -> str:
        # pointer iterate through the str
        n = len(s)
        max_len = 0
        max_str = ""

        # handle single char
        if len(s) == 1:
            return s

        if len(s) == 2:
            if s[0] == s[1]:
                return s
            else:
                return s[0]

        # odd length
        for i in range(1, n-1):
            curr_len = 1
            left, right = i-1, i+1
            while left >= 0 and right < n:
                if s[left] == s[right]:
                    left -= 1
                    right += 1
                    curr_len += 2
                else:
                    break
            if curr_len > max_len:
                max_len = curr_len
                max_str = s[(left+1):right]
                print(max_str)


        # even length
        for i in range(n-1):
            curr_len = 0
            left, right = i, i+1
            while left >= 0 and right < n:
                if s[left] == s[right]:
                    left -= 1
                    right += 1
                    curr_len += 2
                else:
                    break
            if curr_len > max_len:
                max_len = curr_len
                max_str = s[(left+1):right]
        
        
        return max_str