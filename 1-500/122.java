public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(prices == null || prices.length == 0) return 0;
        int hold = 0;
        boolean have = false;
        int earn = 0;
        for(int i = 0; i < prices.length - 1; i++){
            int money = prices[i + 1] - prices[i];
            if(money > 0){
                if(!have){
                    hold = prices[i];
                    have = true;
                }
            }
            else if(money < 0){
                if(have){
                    earn += prices[i] - hold;
                    have = false;
                }
            }
        }
        if(have) earn += prices[prices.length - 1] - hold;
        
        return earn;
        
    }
}
