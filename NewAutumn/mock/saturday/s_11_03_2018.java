package NewAutumn.mock.saturday;

import java.util.*;

public class s_11_03_2018 {
    public static void main(String[] args) {
        s_11_03_2018 test = new s_11_03_2018();
        System.out.println(test.findTrgetInRotatedSortedArray(new int[] {6, 7, 8, 9, 0, 3, 4, 5}, 4));
        System.out.println(test.firstEvenValue(new int[] {1,3,5,4,4,2}));
        System.out.println(test.firstEvenValue(new int[] {1,2}));
        System.out.println(test.firstUniqueChar(new char[] {'a', 'b', 'a', 'c', 'd', 'b', 'e'}));
    }

    public int findTrgetInRotatedSortedArray(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] < array[right]) {
                //右边是增序序列
                if (isInRange(target, array[mid], array[right])) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                //左边是增序序列
                if (isInRange(target, array[left], array[mid])) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    private boolean isInRange(int target, int min, int max) {
        return target >= min && target <= max;
    }

    public int firstEvenValue(int[] array) {
        if (array == null || array.length == 0 || array[array.length - 1] % 2 != 0) {
            return -1;
        }
        if (array[0] % 2 == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] % 2 != 0 && array[mid + 1] % 2 == 0) {
                return mid + 1;
            } else if (array[mid] % 2 == 0 && array[mid + 1] % 2 == 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    class Node {
        public char value;
        public Node next;
        public Node before;
        public Node(char value) {
            this.value = value;
        }
        public void remove() {
            Node before = this.before;
            before.next = this.next;
            this.next.before = before;
            this.before = null;
            this.next = null;
        }
        public void append(Node tail) {
            Node before = tail.before;
            before.next = this;
            tail.before = this;
            this.before = before;
            this.next = tail;
        }
    }
    public char firstUniqueChar(char[] array) {
        Map<Character, Node> reference = new HashMap<>();
        Set<Character> visited = new HashSet<>();
        Node head = new Node(' ');
        Node tail = new Node(' ');
        head.next = tail;
        tail.before = head;
        for (int i = 0; i < array.length; i++) {
            if (visited.add(array[i])) {
                Node cur = new Node(array[i]);
                cur.append(tail);
                reference.put(array[i], cur);
            } else {
                Node cur = reference.get(array[i]);
                cur.remove();
            }
        }
        return head.next.value;
    }

    class NewMap {
        public Map<String, String> map;
        public List<String> keys;
        public Map<String, Integer> keysToIndex;

        public NewMap() {
            this.map = new HashMap<>();
            this.keys = new ArrayList<>();
        }

        public void insert(String key, String value) {
            if (map.containsKey(key)) {
                map.put(key, value);
                return;
            }
            map.put(key, value);
            keysToIndex.put(key, keys.size());
            keys.add(key);
        }

        public String get(String key) {
            if (!map.containsKey(key)) {
                return null;
            }
            return map.get(key);
        }

        public void delete(String key) {
            if (!map.containsKey(key)) {
                return;
            }
            map.remove(key);
            int index = keysToIndex.get(key);
            keysToIndex.remove(key);
            keysToIndex.put(keys.get(keys.size() - 1), index);
            keys.set(index, keys.get(keys.size() - 1));
            keys.remove(keys.size() - 1);
        }

        public String getRandomKey() {
            if (keys.size() == 0) {
                return null;
            }
            Random generator = new Random();
            int index = generator.nextInt(keys.size());
            return keys.get(index);
        }
    }
}
