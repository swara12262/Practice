class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Set<String> set = new HashSet<>();
        int count = N;
        int[] prev = null;
        while(count != 0){
            prev = Arrays.copyOf(cells,cells.length);
            for(int i = 0; i < prev.length; i++){
                cells[i] = 0;
                if(i != 0 && i != prev.length-1 && prev[i-1] == prev[i+1])
                    cells[i] = 1;
            }
			//To detect cycle
            if(!set.add(Arrays.toString(cells)))
                break;
            count--;
        }
        if(set.size() != N){
            return prisonAfterNDays(prev,N%set.size());
        }
        return cells;
    }
}
