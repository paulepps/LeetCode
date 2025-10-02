function rob(nums: number[]): number {
    const n = nums.length;

    if (n === 1) {
        return nums[0];
    }

    let prev = nums[0];
    let secondPrev = 0;

    let loot = 0;
    for (let i = 1; i < n; i++) {
        loot = Math.max(nums[i] + secondPrev, prev);
        secondPrev = prev;
        prev = loot;
    }

    return loot;
}
