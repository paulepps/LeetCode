class Solution {
    public int mySqrt(int x) {
        
        if (x == 0) return 0;

        long n = x;
        long lo = 1, hi = x;
        long res = 1;
        
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            
            // if (mid * mid == x){
            //     res = mid;
            //     break;
            // }

            if (mid * mid <= n){
                res = mid;
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        
        return (int)res;
    }
}