class Solution {
    public int myAtoi(String s) {

        // Remove leading whitespace 
        String trimmedStr = s.replaceFirst("^\\s+", "");

        int len = trimmedStr.length();
        if (len == 0) return 0;

        int i = 0;
        boolean pos = true;

        char ch = trimmedStr.charAt(i);

        // Check for sign character
        if (ch == '-' || (ch == '+')) {
            if (len == 1) return 0;
            i++;

            if (ch == '-') {
                pos = false;
            }
        }

        int digits = 0;

        // Skip leading zeros
        while (i < len && trimmedStr.charAt(i) == '0') {
            i++;
        }

        if (i == len) return 0;

        StringBuilder result = new StringBuilder();

        while (i < len) {
            ch = trimmedStr.charAt(i);
            if (Character.isDigit(ch)) {
                result.append(ch);
                digits++;
                i++;
            } else {
                break;
            } 
        }

        if (digits == 0) return 0;

        String strNum = result.toString();

        // Value might be too big for a long variable
        if (strNum.length() > 10) {
            return (pos) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        long finalNum = Long.parseLong(strNum);

        if (!pos) finalNum *= -1;

        // Rounding
        if (finalNum < Integer.MIN_VALUE) return Integer.MIN_VALUE; 
        if (finalNum > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int)finalNum; 
    }
}