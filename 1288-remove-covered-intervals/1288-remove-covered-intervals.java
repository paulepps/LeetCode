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
        int[] firstInterval = listOfArrays.get(0);

        for (int i = 1; i < listOfArrays.size(); i++) {
            int[] secondInterval = listOfArrays.get(i);
            if (firstInterval[0] > secondInterval[0] 
                    || secondInterval[1] > firstInterval[1]) {
                count++;
                firstInterval = secondInterval;
            }
        } 
        return count;
    }
}