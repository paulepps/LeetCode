function productExceptSelf(nums: number[]): number[] {
    const answer: number[] = [];
    let curr: number = 1;

    for (let i: number = 0; i < nums.length; i++) {
        answer[i] = curr;
        curr *= nums[i];
    }    

    curr = 1;
    for (let i: number = nums.length - 1; i >= 0; i--) {
        answer[i] *= curr;
        curr *= nums[i];
    }

    return answer;        
};