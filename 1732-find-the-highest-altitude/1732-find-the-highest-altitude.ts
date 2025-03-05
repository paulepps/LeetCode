function largestAltitude(gain: number[]): number {
    for (let i = 1; i < gain.length; i++) {
        gain[i] += gain[i - 1];
    }
    return (Math.max(...gain, 0));
};