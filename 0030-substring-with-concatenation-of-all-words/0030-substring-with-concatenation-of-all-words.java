class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.merge(word, 1, Integer::sum);
        }        

        int strLength = s.length();
        int numOfWords = words.length;
        int wordLength = words[0].length();
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < wordLength; i++) {
            Map<String, Integer> currentCount = new HashMap<>();
            int left = i;
            int right = i;
            int totalWords = 0;

            while (right + wordLength <= strLength) {
                String sub = s.substring(right, right + wordLength);
                right += wordLength;

                if (!wordCount.containsKey(sub)) {
                    currentCount.clear();
                    left = right;
                    totalWords = 0;
                    continue;
                }

                currentCount.merge(sub, 1, Integer::sum);
                totalWords++;

                while (currentCount.get(sub) > wordCount.get(sub)) {
                    String removed = s.substring(left, left + wordLength);
                    left += wordLength;
                    currentCount.merge(removed, -1, Integer::sum);
                    totalWords--;
                }

                if (totalWords == numOfWords) {
                    indices.add(left);
                }
            }
        }
        return indices;
    }
}