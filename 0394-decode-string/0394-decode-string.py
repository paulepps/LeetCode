class Solution:
    def decodeString(self, s: str) -> str:
        count_stack = []
        result_stack = []
        current_string = []
        k = 0

        for ch in s:
            if ch.isdigit():
                k = k * 10 + int(ch)
            elif ch == '[':
                count_stack.append(k)
                result_stack.append(''.join(current_string))
                k = 0
                current_string = []
            elif ch == ']':
                repeat_times = count_stack.pop()
                prev_string = result_stack.pop()
                current_string = [prev_string + ''.join(current_string) * repeat_times]
            else:
                current_string.append(ch)

        return ''.join(current_string)
