class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            pq.add(num);
        }

        for (int j = k - 1; j > 0; j--) {
            pq.poll();
        }

        return pq.peek();
    }
}