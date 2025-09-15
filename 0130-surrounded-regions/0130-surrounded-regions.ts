/**
 Do not return anything, modify board in-place instead.
 */
function solve(board: string[][]): void {

    let numRows: number = 0;
    let numCols: number = 0;

    if (board.length === 0 || board[0].length === 0) {
        return;
    }

    numRows = board.length;
    numCols = board[0].length;

    // Mark border-connected 'O's
    for (let i = 0; i < numRows; i++) {
        for (let j = 0; j < numCols; j++) {
            if (
                (i === 0 || i === numRows - 1 ||
                    j === 0 || j === numCols - 1) &&
                board[i][j] === 'O'
            ) {
                dfs(i, j);
            }
        }
    }

    // Flip the cells accordingly
    for (let i = 0; i < numRows; i++) {
        for (let j = 0; j < numCols; j++) {
            if (board[i][j] === '.') {
                board[i][j] = 'O';
            } else if (board[i][j] === 'O') {
                board[i][j] = 'X';
            }
        }
    }

    function dfs(row: number, col: number): void {
        if (
            row < 0 || row >= numRows ||
            col < 0 || col >= numCols ||
            board[row][col] !== 'O'
        ) {
            return;
        }

        board[row][col] = '.';

        dfs(row + 1, col);
        dfs(row - 1, col);
        dfs(row, col + 1);
        dfs(row, col - 1);
    }
};

