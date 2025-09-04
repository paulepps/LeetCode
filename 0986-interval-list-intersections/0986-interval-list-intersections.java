class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        List<int[]> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < firstList.length && j < secondList.length) {
            int[] first = firstList[i];
            int[] second = secondList[j];
            if (isOverlap(first, second)) {
                result.add(new int[]{Math.max(first[0],second[0]), Math.min(first[1], second[1])});
            }
            if (first[1] > second[1])
                j++;
            else if (second[1] > first[1]) 
                i++;
            else {
                i++;
                j++;
            }
        }
        return result.toArray(new int[0][]);
    }

    private boolean isOverlap(int[] a, int[] b) {
        return a[0] <= b[1] && b[0] <= a[1];
    }
}