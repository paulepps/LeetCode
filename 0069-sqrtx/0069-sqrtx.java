class Solution {
    public int mySqrt(int x) {
        
        if (x == 0) return 0;

        double n = x;
        double root;
        double tolerance = 0.00001;

        while (true) {
            root = 0.5 * (n + (x / n));

            if (Math.abs(root - n) < tolerance)
                break;

            n = root;
        }

        return (int)root;
    }
}