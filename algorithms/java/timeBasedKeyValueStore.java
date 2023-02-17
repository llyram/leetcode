class Pair {
    int key;
    String value;    
    public Pair(String value, int key) {
        this.key = key;
        this.value = value;
    }
}
class TimeMap {
    HashMap <String,List<Pair>> map;
    public TimeMap() {
         map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key,new ArrayList<>());
        }
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        else{
            return binarySearch(map.get(key), timestamp);
        }
    }
    public String binarySearch(List<Pair> arr,int timestamp){
        int low = 0, high = arr.size()-1;
        String result = "";
        while(low <= high){
           int mid = (low + high) / 2;
           if(arr.get(mid).key <= timestamp){
               result=arr.get(mid).value;
               low=mid+1;
           }
           else{
               high=mid-1;
           } 
        }
        return result;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */