class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entryList 
                = new ArrayList<>(map.entrySet());
       
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>()
        {
            @Override
            public int compare(Map.Entry<Integer, Integer> entry1, 
                               Map.Entry<Integer, Integer> entry2) 
            {
                return entry2.getValue().compareTo(entry1.getValue());
            }
        });

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = entryList.get(i).getKey();
        }
        return result;
    }
}