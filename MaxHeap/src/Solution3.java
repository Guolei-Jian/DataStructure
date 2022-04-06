import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.PriorityQueue;

// leetcode 347, 使用java内置的priorityQueue, 存储频率
public class Solution3 {

    // 时间复杂度 O(NlogK)
    public List<Integer> topKFrequent(int[] nums, int k){
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: nums){
            if(map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            // lambda 表达式
            (a, b) -> map.get(a) - map.get(b)
        );
        for(int key: map.keySet()){
            if(pq.size() < k)
                pq.add(key);
            else if(map.get(key) > map.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        while(!pq.isEmpty()){
            res.add(pq.remove());
        }
        return res;
    }
}
