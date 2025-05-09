class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.get(0).add(1);

        for(int row = 1; row<numRows; row++){
            
            List<Integer> r = new ArrayList<>();
            List<Integer> prevList = ans.get(row-1);

            r.add(1);
            for(int j=1; j<row; j++){
                r.add(prevList.get(j-1)+prevList.get(j));
            }
            r.add(1);
            ans.add(r);
        }
        return ans;

        
    }
}
