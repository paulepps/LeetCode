class Solution:
    def hammingWeight(self, n: int) -> int:
        count = 0
        while n != 0:
            n &= (n - 1)   # clear the lowest set bit
            count += 1
        return count
