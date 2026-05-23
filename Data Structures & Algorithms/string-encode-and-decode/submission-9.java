class Solution {
    // cause the string contains any possible characters
    // it is hard to know the start and the end of each string
    // so i will add length of each string and a divide symbol like comma, to the start of each string
    // in this way, we can know the start and the end of each string

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length()).append(',').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            // get the len
            int len = 0;
            while(str.charAt(i) != ','){
                len = len * 10 + (str.charAt(i) - '0');// (int)char是ASCII码 
                i++;
            }
            i++;
            res.add(str.substring(i, i + len));
            i += len;
        }
        return res;
    }
}
