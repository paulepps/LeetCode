function kidsWithCandies(candies: number[], extraCandies: number): boolean[] {
    const max = Math.max(...candies);
    const greatest: boolean[] = [];

    for (let i = 0; i < candies.length; i++) {
        greatest[i] = candies[i] + extraCandies >= max;
    }
    return greatest;
};