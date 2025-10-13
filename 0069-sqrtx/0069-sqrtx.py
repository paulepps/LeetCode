class Solution:
    def mySqrt(self, x: int) -> int:
        if x == 0:
            return 0

        n = x
        lo, hi = 1, x
        res = 1

        while lo <= hi:
            mid = lo + (hi - lo) // 2

            if mid * mid == n:
                res = mid
                break

            if mid * mid < n:
                res = mid
                lo = mid + 1
            else:
                hi = mid - 1

        return res
