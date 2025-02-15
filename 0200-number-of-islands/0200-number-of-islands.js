/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    if (grid.length == 0)
        return 0;
 
    let m = grid.length;
    let n = grid[0].length;
 
    let islands=0;
    for(let i=0; i < m; i++){
        for(let j=0; j < n; j++){
            if(grid[i][j] == '1'){
                islands++;
                dfs(grid, i, j);
            }
        }
    }
 
    return islands;
}
 
const dfs = (grid, i, j) => {
    let m=grid.length;
    let n=grid[0].length;
 
    if(i<0 || i>=m || j<0 || j>=n || grid[i][j] != '1')
        return;
 
    grid[i][j]='X';
 
    dfs(grid, i-1, j);
    dfs(grid, i+1, j);
    dfs(grid, i, j-1);
    dfs(grid, i, j+1);
}