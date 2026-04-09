class Solution {
    /*
    use length-prefix encoding
    for each string, store its length, followed by a comma as a delimiter,
    and then the string content
    during decoding, read the length first and extract that many characters
    */

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length()).append(",").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            // I use two pointers to first parse the length until the delimiter,
            // then extract the substring based on that length.
            int j = i;
            while(str.charAt(j) != ','){
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
// tc: o(n)
// sc: o(n)
