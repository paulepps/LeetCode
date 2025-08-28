class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int ans = 0;
        for(int i = 0; i < tickets.length; i++){
            queue.add(i);
        }
        while(!queue.isEmpty()){
            int index = queue.poll();
            tickets[index]--;
            ans++;
            if(tickets[index] == 0 && index == k){
                return ans;
            }
            if(tickets[index] > 0){
                queue.add(index);
            }
        }
        return ans;    }
}