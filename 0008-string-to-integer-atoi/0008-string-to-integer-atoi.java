class Solution {
    public int myAtoi(String s) {

        // Remove leading whitespace 
        s = s.replaceFirst("^\\s+", "");

        int len = s.length();
        if (len == 0) return 0;

        int i = 0;
        int sign = 1;

        char ch = s.charAt(0);

        // Check for sign character
        if (ch == '+' || ch == '-') {
            sign = ch == '+' ? 1 : -1;
            i++;
        }

        long result = 0;
        while (i < len) {
            ch = s.charAt(i);
            if (!Character.isDigit(ch)) {
                break;
            }

            result = result * 10 + (ch - '0');
            if (result * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (result * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }

        return (int)(result * sign); 
    }
}