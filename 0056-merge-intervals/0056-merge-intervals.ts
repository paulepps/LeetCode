function merge(intervals: number[][]): number[][] {
    // Sort intervals by their starting value
    intervals.sort((a, b) => a[0] - b[0]);

    const res: number[][] = [intervals[0]];

    for (let i = 1; i < intervals.length; i++) {
        const prev = res[res.length - 1];
        const curr = intervals[i];

        if (curr[0] <= prev[1]) {
            prev[1] = Math.max(prev[1], curr[1]);
        } else {
            res.push(curr);
        }
    }

    return res;
}
