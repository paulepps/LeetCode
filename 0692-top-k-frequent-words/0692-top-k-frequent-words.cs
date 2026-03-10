public class Solution {
    public IList<string> TopKFrequent(string[] words, int k) {
        int n = words.Length;
        var result = new List<string>();

        // 1. Count frequencies
        var count = new Dictionary<string, int>();
        foreach (var w in words) {
            if (!count.ContainsKey(w)) {
                count[w] = 0;
            }
            count[w]++;
        }

        // 2. Buckets: index = frequency, each bucket holds words with that freq
        var buckets = new List<string>[n + 1];
        foreach (var kvp in count) {
            string word = kvp.Key;
            int freq = kvp.Value;
            if (buckets[freq] == null) {
                buckets[freq] = new List<string>();
            }
            buckets[freq].Add(word);
        }

        // 3. Walk buckets from high freq to low
        for (int freq = n; freq > 0 && result.Count < k; freq--) {
            if (buckets[freq] == null) continue;

            // For equal frequency, words must be in lexicographic order
            buckets[freq].Sort(StringComparer.Ordinal);

            foreach (var word in buckets[freq]) {
                result.Add(word);
                if (result.Count == k) {
                    return result;
                }
            }
        }

        return result;
    }
}