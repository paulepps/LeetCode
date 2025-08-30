class Solution {
    public int sumSubarrayMins(int[] arr) {
int n = arr.length;
        long MOD = 1_000_000_007;

        // prevSmaller[i]: index of the nearest smaller element to the left of arr[i]
        int[] prevSmaller = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            prevSmaller[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // nextSmallerOrEqual[i]: index of the nearest smaller or equal element to the right of arr[i]
        int[] nextSmallerOrEqual = new int[n];
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) { // Use > for strict smaller for nextSmaller
                stack.pop();
            }
            nextSmallerOrEqual[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        
        // Calculate the sum
        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            long leftCount = i - prevSmaller[i];
            long rightCount = nextSmallerOrEqual[i] - i;
            totalSum = (totalSum + (arr[i] * leftCount * rightCount) % MOD) % MOD;
        }

        return (int) totalSum;
    }
}