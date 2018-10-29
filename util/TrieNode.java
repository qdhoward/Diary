package util;

import java.util.*;

public class TrieNode {
    public Map<Character, TrieNode> children;
    public boolean isWord;
    public int count; //Count mean after this node, the number of words with isWord = true
    public TrieNode() {
        this.children = new HashMap<Character, TrieNode>();
    }

    public boolean search(String word, TrieNode root) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode next = cur.children.get(word.charAt(i));
            if (next == null) {
                return false;
            }
            cur = next;
        }
        return cur.isWord;
    }

    public boolean insert(String word, TrieNode root) {
        if (search(word, root)) {
            return false;
        }
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode next = cur.children.get(word.charAt(i));
            if (next == null) {
                next = new TrieNode();
                cur.children.put(word.charAt(i), next);
            }
            cur = next;
            cur.count++;
        }
        cur.isWord = true;
        return true;
    }

    public boolean delete(String word, TrieNode root) {
        if (!search(word, root)) {
            return false;
        }
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode next = cur.children.get(word.charAt(i));
            if (next.count == 1) {
                cur.children.remove(word.charAt(i));
                return true;
            }
            cur = next;
            if (cur.count != 0) {
                cur.count--;
            }
        }
        cur.isWord = false;
        return true;
    }

    public List<String> prefixSearch(String prefix, TrieNode root) {
        TrieNode cur = root;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < prefix.length(); i++) {
            TrieNode next = cur.children.get(prefix.charAt(i));
            if (next == null) {
                return res;
            } else {
                cur = next;
            }
        }
        if (cur.isWord) {
            res.add(prefix);
        }
        Queue<TrieNode> nodeQueue = new LinkedList<>();
        Queue<StringBuilder> pathQueue = new LinkedList<>();
        StringBuilder sb = new StringBuilder(prefix);
        for (Map.Entry<Character, TrieNode> entry : cur.children.entrySet()) {
            nodeQueue.offer(entry.getValue());
            pathQueue.offer(sb.append(entry.getKey()));
        }
        while (!nodeQueue.isEmpty()) {
            TrieNode curNode = nodeQueue.poll();
            StringBuilder curPath = pathQueue.poll();
            if (curNode.isWord) {
                res.add(curPath.toString());
            }
            for (Map.Entry<Character, TrieNode> entry : curNode.children.entrySet()) {
                nodeQueue.offer(entry.getValue());
                pathQueue.offer(sb.append(entry.getKey()));
            }
        }
        return res;
    }
}
