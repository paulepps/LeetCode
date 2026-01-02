class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        Deque<int[]> stack = new ArrayDeque<>();

        int n = temperatures.length;
        int[] answer = new int[n];
        
        for (int i = n - 1; i >= 0; i--) {
            int temp = temperatures[i];

            while (!stack.isEmpty() && temp >= stack.peek()[0]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                answer[i] = stack.peek()[1] - i; 
            }

            stack.push(new int[]{temp, i});
        }
        
        return answer;
    }
}