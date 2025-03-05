function minCostClimbingStairs(cost: number[]): number {
    let costMin: number[] = [];
    costMin[0] = cost[0];
    costMin[1] = cost[1];

    for (let i = 2; i < cost.length; i++) {
        costMin[i] = Math.min(cost[i] + costMin[i - 2], cost[i] + costMin[i - 1]);
    }
    return Math.min(costMin[cost.length - 1], costMin[cost.length - 2]);
};