function climbStairs(n: number): number {
    if (n == 1) return 1;
    if (n == 2) return 2;

    const steps: number[] = [0,1,2];
    for (let i: number = 3; i <= n; i++)
        {
            steps[i] = steps[i-2] + steps[i-1];
        }
    return steps[n];
};