class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        
        List<int[]> listOfArrays = new ArrayList<>();

        for (int[] innerArray : intervals) {
            listOfArrays.add(innerArray);
        }

        Collections.sort(listOfArrays, (arr1, arr2) -> {
            int compareFirst = Integer.compare(arr1[0], arr2[0]);
            if (compareFirst != 0) {
                return compareFirst;
            } else {
                return Integer.compare(arr2[1], arr1[1]);
            }
        });

        int count = 1;
        int firstIntervalEnd = listOfArrays.get(0)[1];

        for (int i = 1; i < listOfArrays.size(); i++) {
            int secondIntervalEnd = listOfArrays.get(i)[1];
            if (secondIntervalEnd > firstIntervalEnd) {
                count++;
                firstIntervalEnd = secondIntervalEnd;
            }
        } 
        return count;
    }
}