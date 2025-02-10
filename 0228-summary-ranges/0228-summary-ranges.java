class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> result = new ArrayList<>();

        for (int startIndex = 0, endIndex; startIndex < nums.length; startIndex = endIndex + 1) {
            endIndex = startIndex;

            while (endIndex + 1 < nums.length && nums[endIndex + 1] == nums[endIndex] + 1) {
                endIndex++;
            }

            result.add(createRangeString(nums, startIndex, endIndex));
        }
        return result;
    }

    String createRangeString(int[] nums, int start, int end) {
        return start == end ? 
            Integer.toString(nums[start]) :
            String.format("%d->%d", nums[start], nums[end]);
    }
}