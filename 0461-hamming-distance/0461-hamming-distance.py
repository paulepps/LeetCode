class Solution:
    def hammingDistance(self, x: int, y: int) -> int:
        xor = x ^ y
        count = 0

        while xor != 0:
            xor &= (xor - 1)  # clear the lowest set bit
            count += 1

        return count
