class Solution {
    public int maxProfit(int k, int[] prices) {
        
    int[] sell = new int[k + 1];
    int[] hold = new int[k + 1];
    Arrays.fill(hold, -prices[0]);

    for (final int price : prices)
      for (int i = k; i > 0; --i) {
        sell[i] = Math.max(sell[i], hold[i] + price);
        hold[i] = Math.max(hold[i], sell[i - 1] - price);
      }

    return sell[k];
    }
}