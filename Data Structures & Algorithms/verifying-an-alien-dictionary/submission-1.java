class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        /*
        Goal:
        "Our goal is to check if the given words are sorted in lexicographical order according to the alien alphabet."

        High level:
        "Build a map to record each character's order in the alien alphabet. 
        Then compare each pair of adjacent words to check if they follow the alien order."

        Main steps:
        "First, build a HashMap mapping each character to its index in the order string.
        Then for each pair of adjacent words, compare them character by character. 
        If the current characters differ, check if they follow the alien order 
        — return true if correct, false if not. If all characters match but one word is longer, 
        the longer word should come second, otherwise return false."

        TC & SC:
        "Time complexity is O(n * m) where n is the number of words and m is the average word length. 
        Space complexity is O(1) since the HashMap stores at most 26 characters."
        */
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
        return one.length() <= two.length();
    }
}