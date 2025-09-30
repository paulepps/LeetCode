class Solution:
    def isValid(self, s: str) -> bool:
        pairs = {')': '(', '}': '{', ']': '['}
        stack = []

        for c in s:
            if c in pairs.values():  # Opening brackets
                stack.append(c)
            elif c in pairs:  # Closing brackets
                if not stack or stack.pop() != pairs[c]:
                    return False
            else:
                # Optional: handle invalid characters if needed
                return False

        return not stack
