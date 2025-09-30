class Solution:
    def isValid(self, s: str) -> bool:
        pairs = {
            '(' : ')',
            '{' : '}',
            '[' : ']'
        } 
        stack = []

        for c in s:
            if c in pairs:  # Opening brackets
                stack.append(c)
            else:
                if not stack or pairs[stack.pop()] != c:
                    return False

        return not stack
