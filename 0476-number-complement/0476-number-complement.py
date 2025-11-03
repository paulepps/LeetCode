class Solution:
    def findComplement(self, num: int) -> int:
        # Get the length of the binary representation
        n = len(bin(num)) - 2  # subtract 2 for the '0b' prefix

        # Flip each bit up to the length of the binary string
        for i in range(n):
            num ^= (1 << i)

        return num


# Example usage:
sol = Solution()
print(sol.findComplement(5))  # Output: 2 (binary 101 -> complement 010)
print(sol.findComplement(1))  # Output: 0 (binary 1 -> complement 0)
