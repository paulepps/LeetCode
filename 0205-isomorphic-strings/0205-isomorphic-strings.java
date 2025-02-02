class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        Map<Character, Character> hashmap = new HashMap<>();

        char c = 'a';

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (hashmap.containsKey(sChar)) {
                c = hashmap.get(sChar);
                if (c != tChar) return false;
            }
            else if (!hashmap.containsValue(tChar)) {
                hashmap.put(sChar, tChar);
            }
            else {
                return false;
            } 
        }
        return true;
    }
}