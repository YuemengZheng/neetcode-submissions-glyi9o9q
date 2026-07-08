class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        // our goal is to check if the order of the words fits the alien order in the string
        // compare two words at one time, check the validation of the order
        int len = words.length;
        if(len <= 1) return true;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for(int i = 1; i < len; i++) {
            if(!isValid(words[i - 1], words[i], map)) return false;
        }
        return true;
    }
    private boolean isValid(String one, String two, Map<Character, Integer> map) {
        int i = 0;
        int j = 0;
        while(i < one.length() && j < two.length()) {
            int orderOne = map.get(one.charAt(i));
            int orderTwo = map.get(two.charAt(j));
            if(orderOne < orderTwo) return true;
            if(orderOne > orderTwo) return false;
            i++;
            j++;
        }
        return i == one.length() && j < two.length() ? true : false;
    }
}