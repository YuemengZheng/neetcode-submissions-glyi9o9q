class Solution {
    public boolean isValid(String s) {
        // use a hashmap to store key is left one, value is the coresponding right one
        // loop through the s, when cur is left, put in the stack
        // when it is right, try to match the top of the stack, if not match, return false
        // otherwise poll the top element 
        Map<Character, Character> pair = new HashMap<>();
        pair.put(']', '[');
        pair.put('}', '{');
        pair.put(')', '(');
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()) {
            if(!pair.containsKey(c)) {
                stack.push(c);
            }else {
                if(!stack.isEmpty() && stack.peek() == pair.get(c)) stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
}
