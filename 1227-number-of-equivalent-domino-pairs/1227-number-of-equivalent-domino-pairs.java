class Solution {
    public int numEquivDominoPairs(int[][] dom) {
        int cnt = 0;
        HashMap<List<Integer>, Integer> map = new HashMap<>();
        for(int i=0;i<dom.length;i++){
            List<Integer> lst = Arrays.asList(dom[i][0], dom[i][1]);
            Collections.sort(lst);
            map.put(lst, map.getOrDefault(lst,0)+1);
        }
        for(List<Integer> lst:map.keySet()){
            System.out.println(map.get(lst));
            if(map.get(lst)>1){
                cnt+=(map.get(lst)*(map.get(lst)-1)/2);
            }

        }
        return cnt;
    }
}