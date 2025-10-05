function permute(nums: number[]): number[][] {
    const perms: number[][] = [];
    const curr: number[] = [];
    const visited: boolean[] = new Array(nums.length).fill(false);

    function _dfs(index: number): void {
        if (index === nums.length) {
            perms.push([...curr]); // Spread to copy
            return;
        }

        for (let j = 0; j < nums.length; j++) {
            if (!visited[j]) {
                visited[j] = true;
                curr.push(nums[j]);
                _dfs(index + 1);
                curr.pop();
                visited[j] = false;
            }
        }
    }

    _dfs(0);
    
    return perms;
}
