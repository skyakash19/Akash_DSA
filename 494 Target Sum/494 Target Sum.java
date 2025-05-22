class Solution {
    public int findTargetSumWays(int[] nums, int target) {
    int sum = 0;
    for (int num : nums) {
        sum += num;
    }
    
    if ((target + sum) % 2 != 0 || sum < Math.abs(target)) return 0;
    
    int S1 = (target + sum) / 2;
    
    if (S1 < 0) return 0;
    
    int[] dp = new int[S1 + 1];
    dp[0] = 1;
    
    for (int num : nums) {
        for (int j = S1; j >= num; j--) {
            dp[j] += dp[j - num];
        }
    }
    
    return dp[S1];
}

}
