class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Integer> Q = new PriorityQueue<>((a, b) -> {
            return Integer.compare(nums[a], nums[b]);
        });

        for (int i = 0; i < nums.length; i++) {
            Q.offer(i);

            if (Q.size() > k) {
                Q.poll();
            }
        }

        List<Integer> ordered = new ArrayList<>(Q);
        Collections.sort(ordered);

        int[] res = new int[k];

        int i = 0;
        for (int index : ordered) {
            res[i++] = nums[index];
        }

        return res;
    }
}