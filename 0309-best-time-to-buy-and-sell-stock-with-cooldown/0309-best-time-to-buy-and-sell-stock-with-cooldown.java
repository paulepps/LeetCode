class Solution {
    public int maxProfit(int[] prices) {
        // States:
        // buy: Max profit ending with a buy or hold action
        // sell: Max profit ending with a sell action
        // cooldown: Max profit ending with a cooldown action

        // Initialize variables:
        // On day 0, we can buy, so the profit is -prices[0].
        // We cannot sell or cooldown on day 0, so their initial profits are 0.
        int buy = -prices[0];
        int sell = 0;
        int cooldown = 0;

        for (int i = 1; i < prices.length; i++) {
            // Store the previous 'buy' and 'sell' values before updating
            int prevBuy = buy;
            int prevSell = sell;
            
            // buy state transitions: 
            // 1. Continue holding (prevBuy)
            // 2. Buy after a cooldown (cooldown - prices[i])
            buy = Math.max(prevBuy, cooldown - prices[i]);

            // sell state transitions: 
            // 1. Sell after a buy (prevBuy + prices[i])
            // Note: A sell can only happen after a buy
            sell = prevBuy + prices[i];

            // cooldown state transitions: 
            // 1. Continue cooldown (cooldown)
            // 2. Start a cooldown after a sell (prevSell)
            cooldown = Math.max(cooldown, prevSell);
        }

        // The maximum profit must end in either a sell or cooldown state.
        // It cannot end in a buy state as that would mean holding a stock, not maximizing profit.
        return Math.max(sell, cooldown);
    }
}
