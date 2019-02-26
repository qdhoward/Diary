package Fun.Amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        // split paragraph
        String[] words = paragraph.split("\\W+");

        // add banned words to set
        Set<String> set = new HashSet<>();
        for(String word : banned){
            set.add(word.toLowerCase());
        }

        // add paragraph words to hash map
        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            if(!set.contains(word)){
                String cur = word.toLowerCase();
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }
        }

        // get the most frequent word
        int max = 0; // max frequency
        String res = "";
        for(String str : map.keySet()){
            if(map.get(str) > max){
                max = map.get(str);
                res = str;
            }
        }
        return res;
    }
}
