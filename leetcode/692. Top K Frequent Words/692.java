class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> m = Maps.newHashMap();
        words.forEach(s -> { 
            m.put(s,m.getOrDefault(s,0)++);
        });
        Collections.sort(words,new Comparator<Entry<String,Integer>>{
            @Override
            public int compare(Entry<String,Integer> l ,Entry<String,Integer> r) {
                return l.getValue()  > r.getValue() ;
            }
        });

    }
}