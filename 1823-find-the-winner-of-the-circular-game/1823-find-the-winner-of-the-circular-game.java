class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> circle = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            circle.offer(i);
        }

        while (circle.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                circle.offer(circle.poll());
            }
            circle.poll();
        }
        return circle.poll();
    }
}