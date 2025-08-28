class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {

        int minutes = 0;
        int idx = k;
        boolean done = false;

        Integer[] integerArray = Arrays.stream(tickets).boxed().toArray(Integer[]::new);
        Queue<Integer> q = new LinkedList<Integer>(Arrays.asList(integerArray));

        while (!done) {
            minutes++;

            int tix = q.poll();
            if (idx == 0 && tix == 1) {
                done = true;
            } else {
                if (tix > 1) {
                    q.offer(tix - 1);
                }
                idx = idx - 1 < 0 ? q.size() - 1 : idx - 1;
            }
        }
        return minutes;
    }
}