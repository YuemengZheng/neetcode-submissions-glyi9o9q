class Solution {
    public boolean isValid(String s) {
        // use stack to store all the openning brackets
        // loop through the string, when it is a left one, store in the stack
        // when right one, check if there is a corresponding open bracket of the same type in the peek 
        // if so, poll the peek
        // else return false, finnaly check whether the stack is empty
        Map<Character, Character> pair = new HashMap<>();
        pair.put('(', ')');
        pair.put('[', ']');
        pair.put('{', '}');
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()) {
            if(pair.containsKey(c)) stack.push(c);
            else {
                if(stack.isEmpty() || pair.get(stack.peek()) != c) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
