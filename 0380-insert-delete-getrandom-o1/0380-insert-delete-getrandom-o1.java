class RandomizedSet {

    List<Integer> arr = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();

    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            int index = arr.size();
            arr.add(val);
            map.put(val, index);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            map.remove(val);
            if (index != arr.size() - 1) {
                int last = arr.size() - 1;
                Collections.swap(arr, index, last);
                if (last != index) {
                    map.put(arr.get(index), index);
                }
            }
            arr.remove(arr.size() - 1);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(arr.size());
        return arr.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */