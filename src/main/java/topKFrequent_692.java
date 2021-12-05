import java.util.*;

import static java.util.Collections.*;

public class topKFrequent_692 {
//    public static List<String> topKFrequent(String[] words, int k) {
//        PriorityQueue<node> pq = new PriorityQueue<>((a,b)-> a.getCount()-b.getCount());
//        Map<String,Integer> map = new HashMap<String,Integer>();
//        List<String> re = new ArrayList<String>();
//        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
//
//        for(String w: words){
//            if(pq.contains()){
//                int val =map.get(w)+1;
//                map.put(w,val);
//            }else {
//                map.put(w,1);
//            }
//        }
//        map.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
//        for (Object key : reverseSortedMap.keySet()) {
//            re.add(key.toString());
//            if  (re.size()==k) {
//                break;
//            }
//        }
//        Collections.sort(re);
//        return re;
//    }
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        List<String> re = new ArrayList<>();
        for(String w: words){
            if(map.containsKey(w)){
                int val =map.get(w)+1;
                map.put(w,val);
            }else {
                map.put(w,1);
            }
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a,b) -> a.getValue()==b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue()-a.getValue()
        );
        for (Map.Entry<String,Integer>m:map.entrySet()){
            pq.offer(m);
        }
        while (re.size()< k){
            re.add(pq.poll().getKey());
        }
        return re;
    }

//        List<String> result = new LinkedList<>();
//        Map<String, Integer> map = new HashMap<>();
//        for(int i=0; i<words.length; i++)
//        {
//            if(map.containsKey(words[i]))
//                map.put(words[i], map.get(words[i])+1);
//            else
//                map.put(words[i], 1);
//        }
//
//        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
//                (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
//        );
//
//        for(Map.Entry<String, Integer> entry: map.entrySet())
//        {
//            pq.offer(entry);
//            if(pq.size()>k)
//                pq.poll();
//        }
//
//        while(!pq.isEmpty())
//            result.add(0, pq.poll().getKey());
//
//        return result;
//    }


    public static void main(String[] args){
        topKFrequent(new String[]{"i","love","leetcode","fuck","interview","i","love","to","play","i"},3 );
    }
}
