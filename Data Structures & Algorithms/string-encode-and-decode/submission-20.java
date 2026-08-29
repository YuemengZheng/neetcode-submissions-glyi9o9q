class Solution {
    /*
    For this problem, the key idea is to use a delimiter that won't conflict with the characters in the strings.
    For encoding, I'll prefix each string with its length followed by a special character like hash, 
    so I know exactly where each string starts and ends. 
    
    For decoding, I'll read the length first, skip the special character, 
    extract that many characters, and repeat the process.


    For encoding，for each string, I encode it into three parts.
    First, I store the length of the original string, then a delimiter, and finally the string itself.
    */
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        /*
        I use i to track the start of each segment. 
        I use j to scan forward until I hit the # delimiter. 
        The substring from i to j gives me the length. 
        Then I skip the # by incrementing j, extract the next len characters as the original string, 
        and move i to the start of the next segment. 
        I repeat this process until i get all the strings.
        */
        int i = 0; 
        while(i < str.length()){
            int j = i; 
            while(str.charAt(j) != '#'){
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j)); // ***** ERROR1 *****
            j++;
            res.add(str.substring(j, j + len));
            i = j + len;
        }
        return res;
    }
}
