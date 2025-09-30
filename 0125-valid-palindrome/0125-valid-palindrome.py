import re
class Solution:
    def isPalindrome(self, s: str) -> bool:
        str_clean = re.sub(r'[^a-z0-9]', '', s.lower())
        if not str_clean:
            return True

        return str_clean == str_clean[::-1]
