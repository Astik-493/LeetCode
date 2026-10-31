class Solution {
    public boolean isSubsequence(String s, String t) {
        // if(s.length()==0 || t.length()==0)
        // return false;

      int i=0;
      
      for(int j=0;j<t.length();j++){
        char ch = t.charAt(j);
        if(i<s.length()){
            if(ch==s.charAt(i))
             i++;
        }
      }
      if(i==s.length())
      return true;

      return false;
    }
}