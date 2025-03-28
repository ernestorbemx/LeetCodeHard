class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        if(n<2) return 0;

        int min_price = prices[0];
        int max_price = prices[n-1];

        int[] profit1 = new int[n];
        int[] profit2 = new int[n];

        for(int i=1;i<n;i++){
            profit1[i] = Math.max(profit1[i-1], prices[i] - min_price);
            min_price = Math.min(min_price, prices[i]);

            int j = n-i-1;
            profit2[j] = Math.max(profit2[j+1], max_price - prices[j]);
            max_price = Math.max(max_price, prices[j]);
        }

        int ans = 0;

        for(int i=0;i<n;i++){
            ans = Math.max(ans, profit1[i] + profit2[i]);
        }

        return ans;

    }
}
