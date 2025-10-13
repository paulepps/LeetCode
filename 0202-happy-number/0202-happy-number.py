class Solution:
    def isHappy(self, n: int) -> bool:
        seen = set()

        while True:
            n = self.sumSquareDigits(n)
            if n == 1:
                return True
            if n in seen:
                return False
            seen.add(n)

    def sumSquareDigits(self, n: int) -> int:
        num = 0
        while n != 0:
            digit = n % 10
            num += digit * digit
            n //= 10
        return num
