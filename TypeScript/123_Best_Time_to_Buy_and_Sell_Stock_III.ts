function maxProfit(prices: number[]): number {
    const n: number = prices.length;
    if(n<2) return 0;

    let min_price: number = prices[0];
    let max_price: number = prices[n-1];
    const profit1: number[] = new Array(n).fill(0);
    const profit2: number[] = new Array(n).fill(0);

    for(let i=1;i<n;i++){
        profit1[i] = Math.max(profit1[i-1], prices[i] - min_price);
        min_price = Math.min(min_price, prices[i]);

        const j: number = n-i-1;
        profit2[j] = Math.max(profit2[j+1], max_price - prices[j]);
        max_price = Math.max(max_price, prices[j]);
    }
    let ans: number = 0;

    for(let i=0;i<n;i++){
        ans = Math.max(ans, profit1[i] + profit2[i]);
    }

    return ans;
};
