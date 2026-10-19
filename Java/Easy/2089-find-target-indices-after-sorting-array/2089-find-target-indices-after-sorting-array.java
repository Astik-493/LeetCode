class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        ArrayList<Integer> ans = new ArrayList<>();
        int count =0;
        int less = 0;

        for(int x:nums){
            if(x==target)
            count++;
            else if(x<target)
            less++;
        }
        for(int i=0;i<count;i++){
            ans.add(less+i);
        }
        return ans;
    }
}