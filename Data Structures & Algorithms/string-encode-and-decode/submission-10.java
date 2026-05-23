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
        // use two pointers to split the string
        int i = 0; // start pointer 
        while(i < str.length()){
            int j = i; // moving pointer
            // get length
            while(str.charAt(j) != ','){
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            //skip the comma
            j++;
            // get that sized string
            res.add(str.substring(j, j + len));
            i = j + len;
        }
        return res;
    }
}
