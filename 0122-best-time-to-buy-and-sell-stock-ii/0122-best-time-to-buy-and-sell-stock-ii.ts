function maxProfit(prices: number[]): number {
    let maxProfit: number = 0;

    for (int i: number = 1; i < prices.length; i++) {
        if (prices[i] > prices[i - 1])
        {
            maxProfit += prices[i] - prices[i - 1];
        }
    }
    return maxProfit;    
};