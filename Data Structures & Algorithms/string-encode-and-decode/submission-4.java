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
        // We use the length prefix to determine the boundary of each string,
        // and a delimiter is used to separate the length from the content.
        // List<String>  res = new ArrayList<>();
        // int i = 0;
        // while(i < str.length()){
        //     int j = i;
        //     while(str.charAt(j) != '#'){
        //         j++;
        //     }
        //     int len = Integer.parseInt(str.substring(i, j));
        //     j++;
        //     res.add(str.substring(j, j + len));
        //     i = j + len;
        // }
        // return res;
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            // use two pointers to continuesly get the length, and the string content 
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
