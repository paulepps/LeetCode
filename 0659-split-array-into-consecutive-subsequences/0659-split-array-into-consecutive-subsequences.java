class Solution {
    public boolean isPossible(int[] arr) {
        // Min-heap stores pairs: {number, length of 
        //subsequence ending with this number}
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]) 
                    // smaller length has higher priority
                    return a[1] - b[1]; 
                // smaller number has higher priority
                return a[0] - b[0];       
            }
        });

        int i = 0;
        while(i < arr.length) {
            if(pq.isEmpty()) {
                // If heap is empty, start a new subsequence
                pq.add(new int[]{arr[i], 1});
                i++;
            }
            else {
                int[] top = pq.peek();
                if(arr[i] == top[0]) {
                    // If current number same as top, 
                    //start a new subsequence
                    pq.add(new int[]{arr[i], 1});
                    i++;
                }
                else if(arr[i] == top[0] + 1) {
                    // If current number is consecutive, 
                    //extend the subsequence
                    pq.poll();
                    pq.add(new int[]{arr[i], top[1] + 1});
                    i++;
                }
                else {
                    // If current number is not 
                    //consecutive, check if top subsequence is valid
                    if(top[1] < 3) return false;
                    pq.poll();
                }
            }
        }

        // After processing all numbers,
        //ensure all subsequences have length >= k
        while(!pq.isEmpty()) {
            if(pq.peek()[1] < 3) return false;
            pq.poll();
        }

        return true;
    }
}