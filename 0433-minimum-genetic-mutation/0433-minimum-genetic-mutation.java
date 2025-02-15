class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        
       Deque<String> queue = new ArrayDeque<>();
       queue.offer(startGene);

       Set<String> visited = new HashSet<>();
       visited.add(startGene);

       int depth = 0;

       while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                String gene = queue.poll();
                if (gene.equals(endGene)) {
                    return depth;
                }

                for (String next : bank) {
                    int c = 2;
                    for (int j = 0; j < 8 && c > 0; j++) {
                        if (gene.charAt(j) != next.charAt(j)) {
                            c--;
                        }
                    }

                    if (c > 0 && !visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            depth++;
        } 
        return -1;
    }
}