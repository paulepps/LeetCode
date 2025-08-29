class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        int x, y;
        String result = "";
        int value;
        String operators ="+-*/";

        for (int i = 0; i < tokens.length; i++)  {
            if (!operators.contains(tokens[i])) {
                stack.push(tokens[i]);
                continue;
            }

            x = Integer.parseInt(stack.pop());
            y = Integer.parseInt(stack.pop());

            switch(tokens[i]) {
                case "+":
                    value = x + y;
                    break;
                    
                case "-":
                    value = y - x;
                    break;
                    
                case "*":
                    value = x * y;
                    break;
                    
                case "/":
                    value = y / x;
                    break;
                
                default:
                    continue;
            }

            result = "" + value;
            stack.push(result);
        }      
        return Integer.parseInt(stack.pop());
    }
}