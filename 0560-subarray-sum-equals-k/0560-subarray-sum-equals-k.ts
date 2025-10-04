function subarraySum(nums: number[], k: number): number {
    const prefixSums: Map<number, number> = new Map();
    prefixSums.set(0, 1); // Handle subarrays starting at index 0

    let count = 0;
    let total = 0;

    for (const num of nums) {
        total += num;

        // Check if (total - k) has been seen before
        const matching = prefixSums.get(total - k) || 0;
        count += matching;

        // Update frequency map
        prefixSums.set(total, (prefixSums.get(total) || 0) + 1);
    }

    return count;
}
