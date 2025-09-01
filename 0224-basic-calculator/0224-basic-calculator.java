class Solution {
    public int calculate(String s) {
        int sum = 0; 
        int sign = 1;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                int val = 0;

                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }
                
                sum += val * sign;
                sign = 1;
                i--;
            } else if (c == '-') {
                sign *= -1;
            } else if (c == '(') {
                stack.push(sum);
                stack.push(sign);
                
                sum = 0;
                sign = 1;
            } else if (c == ')') {
                int poppedSign = stack.pop();
                int prevSum = stack.pop();
                
                sum = (sum * poppedSign) + prevSum;
            }
        }
        return sum;                
    }
}