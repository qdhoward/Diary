package C7_Hashtable_String1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by HaoYu on 2017/10/7.
 */
public class TopKFrequentWords {
    public String[] topKFrequent(String[] combo, int k) {
        // Write your solution here.
        if (combo.length == 0) {
            return new String[0];
        }
        Map<String, Integer> freqMap = new HashMap<>();
        for (String s : combo) {
            Integer freq = freqMap.get(s);
            if (freq == null) {
                freqMap.put(s, 1);
            } else {
                freqMap.put(s, freq + 1);
            }
        }
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else if (entry.getValue() > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        String[] res = new String[minHeap.size()];
        for (int i = minHeap.size() - 1; i >= 0; i--) {
            //TODO 注意，k可能比word的种类多！！所以这儿不能用i=k-1！！
            res[i] = minHeap.poll().getKey();
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.print(new TopKFrequentWords().topKFrequent(new String[] {"d","a","c","b","d","a","b","b","a","d","d","a","d"},5));
    }
}
