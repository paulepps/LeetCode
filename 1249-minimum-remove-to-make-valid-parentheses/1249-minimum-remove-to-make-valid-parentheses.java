class Solution {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    stack.push(c);
                } else {
                    stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder(s);

        while (!stack.isEmpty())
            sb.deleteCharAt(st.pop());
        
        return sb.toString();
    }
}