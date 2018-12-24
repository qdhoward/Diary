package LeetCode.Company.Amazon;

import java.util.*;

public class WordLadder127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // queue is used to do bfs
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> words = new HashSet<>(wordList);
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String cur = queue.poll();
                if(cur.equals(endWord)){
                    return count + 1;
                }
                char[] arr = cur.toCharArray();
                for(int j = 0; j < cur.length(); j++){
                    char tmp = arr[j];
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        arr[j] = ch;
                        String newS = new String(arr);
                        if(!newS.equals(cur) && words.contains(newS)){
                            queue.offer(newS);
                            words.remove(newS);
                        }
                    }
                    arr[j] = tmp;
                }
            }
            count++;
        }
        return 0;
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
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
                    for (char k = 'a'; k <= 'z'; k++) {
                        char tmp = cur[j];
                        cur[j] = k;
                        String curStr = new String(cur);
                        if (curStr.equals(endWord) && words.contains(endWord)) {
                            return step;
                        }
                        if (words.contains(curStr)) {
                            queue.offer(curStr);
                            words.remove(curStr);
                        }
                        cur[j] = tmp;
                    }
                }
            }
        }
        return 0;
    }
}
