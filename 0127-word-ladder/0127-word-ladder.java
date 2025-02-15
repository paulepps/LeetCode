class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
       Deque<String> queue = new ArrayDeque<>();
       queue.offer(beginWord);

       Set<String> words = new HashSet<>(wordList);

       int result = 1;

       while (!queue.isEmpty()) {
            result++;

            for (int i = queue.size(); i > 0; i--) {
                String s = queue.poll();
                char[] chars = s.toCharArray();

                for (int j = 0; j < chars.length; j++) {
                    char ch = chars[j];

                    for (char k = 'a'; k <= 'z'; k++) {
                        chars[j] = k;
                        String s2 = new String(chars);
                        if (!words.contains(s2)) {
                            continue;
                        }
                        if (endWord.equals(s2)) {
                            return result;
                        }
                        queue.offer(s2);
                        words.remove(s2);
                    }

                    chars[j] = ch;
                }
            }
        } 
        return 0;
    }
}