class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        // Min-heap: worst candidate on top
        PriorityQueue<String> pq = new PriorityQueue<>((w1, w2) -> {
            int f1 = freq.get(w1);
            int f2 = freq.get(w2);
            if (f1 != f2) {
                return Integer.compare(f1, f2); // lower freq first
            }
            return w2.compareTo(w1);            // lexicographically larger first
        });

        for (String word : freq.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll(); // remove worst candidate
            }
        }

        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        Collections.reverse(result); // heap gives lowest-first, reverse to highest-first
        return result;
    }
}