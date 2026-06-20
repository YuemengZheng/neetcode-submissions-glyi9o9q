class Solution {

    public String encode(List<String> strs) {
        // use three parts: len + # + string
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        // use two pointers, i -> start of the segment, j -> scan forward
        // 1. find the len
        // 2. skip the #
        // 3. extract that many characters
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            j++;
            String s = str.substring(j, j + len);
            res.add(s);
            i = j + len;
        }
        return res;
    }
}
