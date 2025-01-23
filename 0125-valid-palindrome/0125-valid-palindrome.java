class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        str = str.replaceAll("[^a-z0-9]", "");

        if (str.isEmpty()) return true;

        StringBuilder reversed = new StringBuilder(str);
        reversed.reverse();
        String rstr = reversed.toString();

        return str.equals(rstr);
    }
}