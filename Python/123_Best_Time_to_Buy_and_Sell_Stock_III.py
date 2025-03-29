class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        # If the lenght is less than 2 there are no posible profits
        if n < 2:
            return 0
        
        # Variables to save min and max price
        min_price = prices[0]
        max_price = prices[n-1]
        # List to save the profit at each position
        # Forward
        profit1 = [0] * n 
        # Backward
        profit2 = [0] * n

        # Save the profits and the min and max prices
        for i in range(1,n):
            profit1[i] = max(profit1[i-1], prices[i] - min_price) # Update the profit at position i if its greater
            min_price = min(min_price, prices[i])  # Update minimum price

            j = n-1-i 
            profit2[j] = max(profit2[j+1], max_price - prices[j]) # Update the profit at position j if its greater
            max_price = max(max_price, prices[j])  # Update maximum price

        ans = 0 

        # Search the maximum profit using the profit1 plus profit2 at position i
        for i in range(n):
            ans = max(ans, profit1[i] + profit2[i])

        return ans
