class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(0, s);
        return res; 
    }
    private void backtrack(int start, String s){
        if(start == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = start; i < s.length(); i++){
            String substring = s.substring(start, i + 1);
            if(!isPalindrome(substring)) continue;
            path.add(substring);
            backtrack(i + 1, s);
            path.remove(path.size() - 1); 
        }
    }
    private boolean isPalindrome(String s){
        int l = 0;
        int r = s.length() - 1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
