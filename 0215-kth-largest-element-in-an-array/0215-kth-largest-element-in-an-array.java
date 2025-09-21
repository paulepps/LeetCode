class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> Q = new PriorityQueue<>();
        for (int num : nums) {
            Q.add(num);
        }

        for (int i = 0; i < nums.length - k; i++) {
            Q.poll();
        }

        return Q.peek();
    }
}
