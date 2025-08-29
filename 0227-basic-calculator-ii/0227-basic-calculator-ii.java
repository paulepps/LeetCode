class Solution {
    public int calculate(String s) {
        
        s = s.replace(" ", "");

        Deque<Character> opStack = new ArrayDeque<>();
        Deque<Integer> numStack = new ArrayDeque<>();

        char op = '+';
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                int val = 0;

                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }
                
                i--;

                switch (op) {
                case '+':
                    numStack.push(val);
                    break;
                case '-':
                    numStack.push(-val);
                    break;
                case '*':
                    numStack.push(numStack.pop() * val);
                    break;
                case '/':
                    numStack.push(numStack.pop() / val);
                    break;
                }

            } else {
                op = c;
            }
        }

        int result = 0;
        while (!numStack.isEmpty()) {
            result += numStack.pop();
        }
        return result;   
    }
}