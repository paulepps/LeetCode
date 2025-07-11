class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();

        int[] result = new int[temperatures.length];

        stack.push(0);

        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() 
                    && temperatures[i] > temperatures[stack.peek()]) {
                result[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}