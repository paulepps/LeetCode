class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int c=0 , i=0;
        int n= tickets.length;
        while(tickets[k]>0){
            if(tickets[i]>0){
                tickets[i]--;
                c++;
            }
            i++;
            //System.out.println(c);
            if(i==n){
                i=0;
            }
        }
        return c;
    }
}