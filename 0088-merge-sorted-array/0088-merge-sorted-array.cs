public class Solution {
    public void Merge(int[] nums1, int m, int[] nums2, int n) {
        int openSlot = m;
        foreach (int num in nums2)
        {
            int j = openSlot++;
            nums1[j] = num;
            while (j > 0 && nums1[j] < nums1[j - 1])
            {
                int temp = nums1[j];
                nums1[j] = nums1[j - 1];
                nums1[j - 1] = temp;
                j--;
            }
        }
    }
}