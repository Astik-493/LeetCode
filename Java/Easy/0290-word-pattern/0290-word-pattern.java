class Solution {
    public boolean wordPattern(String pattern, String s) {
         HashMap<Character, String> map = new HashMap<>();
        HashSet<String> used = new HashSet<>();
        String[] x = s.split(" ");

        if(pattern.length()!=x.length)
        return false;
        
        for(int i = 0; i < pattern.length(); i++) {
            char a = pattern.charAt(i);
            String b = x[i];

            if(map.containsKey(a)) {
                if(!map.get(a).equals(b))
                    return false;
            }
            else {
                if(used.contains(b))
                    return false;

                map.put(a, b);
                used.add(b);
            }
        }

        return true;
    }
}