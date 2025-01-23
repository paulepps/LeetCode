class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        String[] arr = new String[numRows];
        Arrays.fill(arr, "");

        int row = 0;
        boolean down = true;

        for (int i = 0; i < s.length(); i++) {
            arr[row] += s.charAt(i);

            if (row == numRows - 1)
                down = false;
            else if (row == 0)
                down = true;
            
            if (down)
                row++;
            else
                row--;
        }

        String result = "";
        for (int i = 0; i < numRows; i++) {
            result += arr[i];
        }

        return result;
    }
}