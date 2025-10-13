class Solution:
    def titleToNumber(self, columnTitle: str) -> int:
        decimal_value = 0
        power = 0  # Represents 26^0, 26^1, 26^2, etc.

        # Iterate from the rightmost character (least significant digit)
        for i in range(len(columnTitle) - 1, -1, -1):
            digit_char = columnTitle[i]

            # Convert character to its numerical value (A=1, B=2, ..., Z=26)
            digit_value = ord(digit_char) - ord('A') + 1

            # Add (digit_value * 26^power) to the decimal value
            decimal_value += digit_value * (26 ** power)

            power += 1  # Increment power for the next digit

        return decimal_value
