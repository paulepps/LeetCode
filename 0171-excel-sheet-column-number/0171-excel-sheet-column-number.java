class Solution {
    public int titleToNumber(String columnTitle) {
        int decimalValue = 0;
        long power = 0; // Represents 26^0, 26^1, 26^2, etc.

        // Iterate from the rightmost character (least significant digit)
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            char digitChar = columnTitle.charAt(i);

            // Convert character to its numerical value (A=1, B=2, ..., Z=26)
            int digitValue = digitChar - 'A' + 1;

            // Add (digitValue * 26^power) to the decimal value
            decimalValue += digitValue * Math.pow(26, power);

            power++; // Increment power for the next digit
        }
        return decimalValue;
    }
}