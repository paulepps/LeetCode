class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
		for (int i = 0; i < prices.length; i++) {
			profit = Math.max(profit, getMaxProfit(prices, 0, i) + getMaxProfit(prices, i + 1, prices.length - 1));
		}
		return profit;
    }

    private int getMaxProfit(int[] prices, int start, int end) {
		int profit = 0, minPrice = Integer.MAX_VALUE;
		for(int i = start; i <= end; i++) {
			minPrice = Math.min(minPrice, prices[i]);
			profit = Math.max(profit, prices[i] - minPrice);
		}
		return profit;
	}
}