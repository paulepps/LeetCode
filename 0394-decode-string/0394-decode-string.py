class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        result = ""
        k = 0

        for i in range(len(s)):
            ch = s[i]
            if ch.isdigit():
                k = k * 10 + int(ch)
            elif ch == '[':
                stack.append((result, k))
                result = ""
                k = 0
            elif ch == ']':
                if stack:
                    prev_string, repeat_times = stack.pop()
                    result = prev_string + repeat_times * result
            else:
                result += ch

        return result
