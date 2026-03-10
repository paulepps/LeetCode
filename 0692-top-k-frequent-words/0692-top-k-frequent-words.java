class Solution {
    public List<String> topKFrequent(String[] words, int k) {
                Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        List<String> candidates = new ArrayList<>(freq.keySet());

        // Sort by: frequency desc, then word asc
        Collections.sort(candidates, (w1, w2) -> {
            int f1 = freq.get(w1);
            int f2 = freq.get(w2);
            if (f1 != f2) {
                return Integer.compare(f2, f1); // higher freq first
            }
            return w1.compareTo(w2);            // lexicographically smaller first
        });

        return candidates.subList(0, k);
    }
}