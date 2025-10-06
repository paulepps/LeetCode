class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;
        int[] costMin = new int[n];

        costMin[0] = cost[0];
        costMin[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            costMin[i] = 
                Math.min(cost[i] + costMin[i - 2], cost[i] + costMin[i - 1]);
        }
        return Math.min(costMin[cost.length - 1], costMin[cost.length - 2]);
    }
}