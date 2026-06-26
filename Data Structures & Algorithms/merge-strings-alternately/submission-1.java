class Solution {
    public String mergeAlternately(String word1, String word2) {
        // use two pointers starting from both strings, take one char from them alternatively to build the new string
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while(i < word1.length() && j < word2.length()){
            sb.append(word1.charAt(i++)).append(word2.charAt(j++));
        }
        if(i < word1.length()){
            sb.append(word1.substring(i));
        }
        if(j < word2.length()){
            sb.append(word2.substring(j));
        }
        return sb.toString();
    }
}