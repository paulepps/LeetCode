function majorityElement(nums: number[]): number {
    
    let candidate: number = -1;
    let count: number = 0;

    // Find a candidate
    for (const num of nums) {
        if (count === 0) {
            candidate = num;
            count = 1;
        } else if (num === candidate) {
            count++;
        } else {
            count--;
        }
    }

    return candidate;
};