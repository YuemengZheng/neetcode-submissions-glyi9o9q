class Solution {
    /*The high-level idea is to use length-prefix encoding.
    For each string, I store its length first, then add a delimiter, and then the actual string content.
    During decoding, I scan the encoded string from left to right, first read the length, 
    then use that length to extract the exact substring.
    This way, the content itself does not affect parsing, even if it contains special characters
    */

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        // We use the length prefix to determine the boundary of each string,
        // and a delimiter is used to separate the length from the content.
        List<String>  res = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            j++;
            res.add(str.substring(j, j + len));
            i = j + len;
        }
        return res;
    }
}
