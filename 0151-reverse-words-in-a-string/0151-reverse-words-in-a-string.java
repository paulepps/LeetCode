class Solution {
    public String reverseWords(String s) {
        String arr[] = s.trim().split("\\s+");
        String reversed = "";

        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                reversed = arr[i] + reversed;
            } else {
                reversed = " " + arr[i] + reversed;
            }
        }
        return reversed;
    }
}