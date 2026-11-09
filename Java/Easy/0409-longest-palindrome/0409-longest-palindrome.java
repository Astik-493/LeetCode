class Solution {
    public int longestPalindrome(String s) {
        int [] freq = new int [128];
        boolean one = false;
        int ans = 0;
        for(char ch : s.toCharArray())
        freq[ch]++;
       
        for(int i=0;i<128;i++){
            if(freq[i]%2==0)
                ans+=freq[i];

            else{
                ans+=(freq[i] - 1);
                one = true;
            }
        }
        if(one)
            ans+=1;
    
    return ans;
    }
}