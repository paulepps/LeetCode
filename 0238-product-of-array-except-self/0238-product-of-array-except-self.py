class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        answer = [0] * len(nums)
        curr = 1

        for i in range(len(nums)):
            answer[i] = curr
            curr *= nums[i]

        curr = 1
        for i in range(len(nums) - 1, -1, -1):
            answer[i] *= curr
            curr *= nums[i]

        return answer

            