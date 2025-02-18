class Solution {
    private List<String> result;
    private String[] map = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    private char[] charDigits;
    private int len;

    public List<String> letterCombinations(String digits) {
        
        result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        
        charDigits = digits.toCharArray();
        len = digits.length();

        backtrack("");
        return result;
    }
    
    public void backtrack(String s) {

        int i = s.length();

        if (i == len) { 
            result.add(s); 
            return;
        }
        
        int digit = charDigits[i] - '2';

        for (char letter : map[digit].toCharArray()) {
            backtrack(s + letter);
        }
    }}