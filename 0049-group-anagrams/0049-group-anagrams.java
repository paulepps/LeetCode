class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> anagramsMap = new HashMap<>();

        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);

            String sortedStr = String.valueOf(arr);

            anagramsMap.computeIfAbsent(sortedStr, key -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(anagramsMap.values());
    }
}