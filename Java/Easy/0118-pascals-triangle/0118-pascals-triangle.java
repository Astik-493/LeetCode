class Solution {
     public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        long res =1;
        ans.add(1);
         for (int i = 1; i <= rowIndex; i++) {
            res = res * (rowIndex - i + 1) / i;
            ans.add((int) res);
        }

        return ans;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            ans.add(getRow(i));
        }
        return ans;
    }
}