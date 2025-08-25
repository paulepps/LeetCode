class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();

        int n = nums.length;
        int[] maxArray = new int[n - k + 1];

        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && q.peekFirst() < i - k + 1) {
                q.pollFirst();
            }

            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }

            q.offerLast(i);

            if (i >= k - 1) {
                maxArray[i - k + 1] = nums[q.peekFirst()];
            }
        }

        return maxArray;
    }
}