class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> Q 
                = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            Q.offer(stone);
        }

        while (Q.size() > 1) {
            int y = Q.poll();
            int x = Q.poll();
            
            int result = y - x;

            if (result > 0) {
                Q.offer(result);
            }
        }
        return Q.size() == 0 ? 0 : Q.peek();
    }
}