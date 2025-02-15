class Solution {

    private int boardSize;

    public int snakesAndLadders(int[][] board) {

        boardSize = board.length;

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);

        boolean[] visited = new boolean[boardSize * boardSize + 1];
        visited[1] = true;

        int moves = 0;

        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; --i) {
                int curr = queue.poll();
                if (curr == boardSize * boardSize) {
                    return moves;
                }

                for (int j = curr + 1; 
                        j <= Math.min(curr + 6, boardSize * boardSize); j++) {
                    int[] position = convertToPosition(j);
                    int next = j;

                    if (board[position[0]][position[1]] != -1) {
                        next = board[position[0]][position[1]];
                    }

                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
            moves++;
        }
        return -1;
    }

    private int[] convertToPosition(int square) {
        int row = (square - 1) / boardSize;
        int col = (square - 1) % boardSize;
    
        if (row % 2 == 1) {
            col = boardSize - col - 1; 
        }
    
        return new int[] {boardSize - row - 1, col};
    }
}