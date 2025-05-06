class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int tank = 0;
        int startIndex = 0;
        
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];
            
            if (tank < 0) {
                startIndex = i + 1;
                tank = 0;
            }
        }
        
    
        if (totalGas < totalCost) {
            return -1;
        }
        
        return startIndex;
    }

}
