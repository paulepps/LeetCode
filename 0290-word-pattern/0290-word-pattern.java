class Solution {
    public boolean wordPattern(String pattern, String s) {

        Map<Character, String> hashmap = new HashMap<>();

        String[] arr = s.split(" ");

        if (pattern.length() != arr.length) return false;

        String word = "";

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String str = arr[i];

            if (hashmap.containsKey(c)) {
                word = hashmap.get(c);
                if (!word.equals(str)) return false;
            }
            else if (!hashmap.containsValue(str)) {
                hashmap.put(c, str);
            }
            else {
                return false;
            } 
        }
        return true;

    }
}