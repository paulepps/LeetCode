class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (true) {
            n = sumSquareDigits(n);
            if (n == 1)
                return true;
            if (seen.contains(n))
                return false;
            seen.add(n);
        }
    }

    private int sumSquareDigits(int n) {
        int num = 0;
        while (n != 0) {
            int digit = n % 10;
            num += digit * digit;
            n /= 10;
        }
        return num;
    }
}