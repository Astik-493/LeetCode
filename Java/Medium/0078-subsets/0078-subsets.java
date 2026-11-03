class Solution {
    public void subset(int i,int [] nums,List<Integer> curr,List<List<Integer>> res){
        if(i == nums.length){
           res.add(new ArrayList<>(curr));
           return; 
        }

        subset(i+1,nums,curr,res);
        curr.add(nums[i]);
        
        subset(i+1,nums,curr,res);
        curr.remove(curr.size() - 1);

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res  = new ArrayList<>();
        subset(0,nums,new ArrayList<>(),res);

        return res;
    }
}