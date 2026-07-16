class Solution {
    // string contains all kinds of characters out of ascii characters
    // we need to get the start and the end of each string
    // use length-prefix encoding
    // for each string, it contains the length of the string, a delimiter(hash), the string itself
    // for the decoding, first get the length, skip the delimiter, get that many charaters as a string
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while(i < str.length()) {
            int j = i; // j is the start of the segment
            while(str.charAt(i) != '#'){
                i++;
            }
            int len = Integer.parseInt(str.substring(j, i));
            i++;
            list.add(str.substring(i, i + len));
            i += len;
        }
        return list;
    }
}
