class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>
                    (Comparator.comparingInt(i -> nums[i]));
        for (int i = 0; i < nums.length; ++i) {
            pq.offer(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.stream().sorted().mapToInt(i -> nums[i]).toArray();    }
}