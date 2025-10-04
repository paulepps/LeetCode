function intersection(nums1: number[], nums2: number[]): number[] {
    const seen = new Set<number>(nums1);
    const result: number[] = [];

    for (const num of nums2) {
        if (seen.has(num)) {
            result.push(num);
            seen.delete(num); // Avoid duplicates
        }
    }

    return result;
}
