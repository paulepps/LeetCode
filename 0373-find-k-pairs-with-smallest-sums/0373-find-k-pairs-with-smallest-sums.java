class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.offer(new int[]{nums1[i] + nums2[0], i , 0});
        }

        List<List<Integer>> ans = new ArrayList<>();

        while (!pq.isEmpty() && k-- > 0) {
            int[] el = pq.poll();
            ans.add(Arrays.asList(nums1[el[1]], nums2[el[2]]));

            if (el[2] + 1 < nums2.length) {
                pq.offer(new int[]{nums1[el[1]] + nums2[el[2]+1], el[1] , el[2] + 1});
            }
        }
        return ans;
    }
}