class Solution {
    public int minPatches(int[] nums, int n) {
        List<Long> list = new ArrayList<>();
        for(int i : nums) {
            list.add((long)i);
        }


        int patches = 0;
        long k=0; // coverage
        long lastInserted=nums[0];
        int lastIx = -1;
        while(k<n) {
            long s = k+1; // best solution search element 
            final long lower=lastInserted;
            final long upper=s;
            // search a number in shortened list
            // that is between [lastInserted, k+1]
            Optional<Pair<Integer,Long>> opt = IntStream.range(lastIx+1, list.size())
                    .mapToObj(i -> new Pair<Integer, Long>(i, list.get(i)))
                    .filter(p -> p.getValue() >=lower && p.getValue() <= upper)
                    .reduce((p1,p2)-> p1);
            // Optional<Integer> opt = list.stream().skip(lastIx+1).filter(n1-> n1>=lower && n1<=upper).reduce((a,b)-> b);
            if(opt.isPresent()) {
                Pair<Integer,Long> p = opt.get();
                long t = p.getValue();
                k=k+t;
                lastInserted=t;
                lastIx=p.getKey();
                continue;
            }
            //int ix = Arrays.binarySearch(nums,s);
            int ix = Collections.binarySearch(list,s);
            if (ix < 0) {
                patches++;
                list.add(-(ix+1),s);
                lastInserted = s;
                lastIx = -(ix+1);
                // Collections.sort(list);
            } else {
                lastIx = ix;
            }
            k = k + s;
        }
        return patches;
    }
}
