class Solution {
     public void ans(int n, int lastPlace, String str, List<String> res) {
        if(n == 0) {
            res.add(str);
            return;
        }
        ans(n - 1, 1, str + "1",res);

        if(lastPlace == 1) 
            ans(n - 1, 0, str + "0",res);
    }
    public List<String> validStrings(int n) {
        ArrayList<String> res = new ArrayList<>();

        ans(n, 1, "", res);
        return res;
    }
}