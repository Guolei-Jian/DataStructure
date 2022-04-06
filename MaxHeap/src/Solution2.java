import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.PriorityQueue;

// leetcode 347, 使用java内置的priorityQueue, 默认是最小堆
public class Solution2 {

    // 时间复杂度 O(NlogK)
    private class Freq implements Comparable<Freq>{
        public int e, freq;

        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            // 因为java的优先队列是最小堆，所以频率越高，优先级越高
            if(this.freq < another.freq)
                return -1;
            else if (this.freq > another.freq)
                return 1;
            else
                return 0;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k){
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: nums){
            if(map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for(int key: map.keySet()){
            if(pq.size() < k)
                pq.add(new Freq(key, map.get(key)));
            else if(map.get(key) > pq.peek().freq){
                pq.remove();
                pq.add(new Freq(key, map.get(key)));
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        while(!pq.isEmpty()){
            res.add(pq.remove().e);
        }
        return res;
    }
}
