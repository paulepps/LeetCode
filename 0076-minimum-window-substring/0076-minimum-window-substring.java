class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";

        int[] hashPattern = new int[256];
        int[] hashString = new int[256];

        for (int i = 0; i < t.length(); i++) {
            hashPattern[t.charAt(i)]++;
        }

        int start = 0;
        int startIndex = -1;
        int minLength = Integer.MAX_VALUE;
        int count = 0;

        for (int j = 0; j < s.length(); j++) {
            hashString[s.charAt(j)]++;

            if (hashString[s.charAt(j)] <= hashPattern[s.charAt(j)]) {
                count++;
            }

            if (count == t.length()) {
                while (hashString[s.charAt(start)] > hashPattern[s.charAt(start)]
                        || hashPattern[s.charAt(start)] == 0) {

                    if (hashString[s.charAt(start)] > hashPattern[s.charAt(start)]) {
                        hashString[s.charAt(start)]--;
                    }
                    start++;                                            
                }

                int lenWindow = j - start + 1;
                if (minLength > lenWindow) {
                    minLength = lenWindow;
                    startIndex = start;
                }
            }
        }

        if (startIndex == -1) {
            return "";
        }

        return (s.substring(startIndex, startIndex + minLength));
    }
}