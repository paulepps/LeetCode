class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> triplets = new ArrayList<>();

        for (int first = 0; first < nums.length - 2 && nums[first] <=0; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            
            int l = first + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[first] + nums[l] + nums[r];

                if (sum < 0) {
                    l++;
                } 
                else if (sum > 0) {
                    r--;
                } 
                else {
                    triplets.add(List.of(nums[first], nums[l], nums[r]));

                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                }
            }
        }
        return triplets;
    }
}