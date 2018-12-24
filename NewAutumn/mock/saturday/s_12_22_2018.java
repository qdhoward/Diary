package NewAutumn.mock.saturday;

import com.sun.tools.corba.se.idl.StringGen;

import java.util.*;

public class s_12_22_2018 {
    class Node {
        int val;
        List<Integer> path;

        Node(int val) {
            this.val = val;
            this.path = new ArrayList<>();
        }
    }

    //Time O(mn) Space O(n) n is number of nodes, m is number of neighbors
    public List<Integer> findShortestCycle(int[][] gragh, int target) {
        Queue<Node> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        Node cur = new Node(target);
        cur.path.add(target);
        queue.offer(cur);
        visited.add(target);

        while (!queue.isEmpty()) {
            cur = queue.poll();
            for (int i = 0; i < gragh[cur.val].length; i++) {
                if (gragh[cur.val][i] == target) {
                    return cur.path;
                }
                if (visited.add(gragh[cur.val][i])) {
                    Node next = new Node(gragh[cur.val][i]);
                    next.path = new ArrayList<>(cur.path);
                    next.path.add(gragh[cur.val][i]);
                    queue.offer(next);
                }
            }
        }
        return new ArrayList<>();
    }

    class Dictionary {
        String[] dict;
        Map<String, List<String>> map;

        Dictionary(String[] dict) {
            this.dict = dict;
            this.map = new HashMap<>();
            buildMap(this.dict);
        }

        private void buildMap(String[] dict) {
            for (String s : dict) {
                char[] array = s.toCharArray();
                Arrays.sort(array);
                String sortedString = new String(array);
                if (!map.containsKey(sortedString)) {
                    map.put(sortedString, new ArrayList<>());
                }
                map.get(sortedString).add(s);
            }
        }

        public List<String> allAnagrams(String target) {
            return map.get(target);
        }
    }

    public interface NestedMap {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedMap holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedMap> getList();
    }

    public class NestedIterator implements Iterator<Integer> {
        private Deque<NestedMap> stack;

        public NestedIterator(List<NestedMap> nestedMap) {
            this.stack = new ArrayDeque<>();
            for (NestedMap map : nestedMap) {
                stack.push(map);
            }
        }

        @Override
        public Integer next() {
            while (hasNext()) {
                if (stack.peek().isInteger()) {
                    return stack.pop().getInteger();
                } else {
                    List<NestedMap> next = stack.pop().getList();
                    for (NestedMap n : next) {
                        stack.push(n);
                    }
                }
            }
            return null;
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

}
