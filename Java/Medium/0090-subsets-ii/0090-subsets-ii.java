class Solution {
    public void subset(int start, int[] nums, List<Integer> curr, List<List<Integer>> res) {
        // if (start == nums.length) {
            res.add(new ArrayList<>(curr));
            // return;
        // }
        // subset(i + 1, nums, curr, res);

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;

        curr.add(nums[i]);
        subset(i + 1, nums, curr, res);
        curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        subset(0, nums, new ArrayList<>(), res);
        return res;
    }
}