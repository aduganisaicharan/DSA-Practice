class Solution {
    static int mod=(int)(1e9+7);
    public int[] baseUnitConversions(int[][] con) {
        TreeMap<Integer, Long> hash = new TreeMap<>();
        hash.put(0, 1L);
        for(int i=0;i<con.length;i++){
            hash.put(con[i][1], (hash.getOrDefault(con[i][1], 0L) + con[i][2])%mod);
        }
        for(int i=0;i<con.length;i++){
            hash.put(con[i][1], (con[i][2]*1L*hash.get(con[i][0]))%mod);
        }
        int arr[] = new int[hash.size()];
        int ind = 0;
        for(int it:hash.keySet()){
            arr[ind++] =(int)(1L*hash.get(it)%mod);
        }
        return arr;
    }
}