class Solution {
    public boolean isValid(String s) {
        /*
        This problem is about validating whether brackets are matched in the correct order. 
        Since the most recently opened bracket must be closed first, 
        we can use a stack to track unmatched opening brackets. 
        We also need to ensure the bracket types match, which can be checked using a hashmap.
        */
        // ***** TIME: O(n), SPACE:O(n) *****
        Map<Character, Character> closeToOpen = new HashMap<>();
        closeToOpen.put(')', '(');
        closeToOpen.put(']', '[');
        closeToOpen.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(closeToOpen.containsKey(c)){
                if(!stack.isEmpty() && stack.peek() == closeToOpen.get(c)){
                    stack.pop();
                }else{
                    return false;
                }
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
