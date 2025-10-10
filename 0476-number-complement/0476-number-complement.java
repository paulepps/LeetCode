class Solution {
    public int findComplement(int num) {
        
        int n = Integer.toBinaryString(num).length();

        for (int i = 0; i < n; i++) {
            num ^= (1 << i);
        }
        return num;
    }
}