package Fun.Bloomberg;

import java.util.*;

public class wordLadder {
    //BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> words = new HashSet<>(wordList);
        queue.offer(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                char[] cur = queue.poll().toCharArray();
                for (int j = 0; j < cur.length; j++) {
                    char tmp = cur[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        cur[j] = k;
                        String curStr = new String(cur);
                        if (curStr.equals(endWord) && words.contains(endWord)) {
                            return step;
                        }
                        if (words.contains(curStr)) {
                            queue.offer(curStr);
                            words.remove(curStr);
                        }
                    }
                    cur[j] = tmp;
                }
            }
        }
        return 0;
    }
}
