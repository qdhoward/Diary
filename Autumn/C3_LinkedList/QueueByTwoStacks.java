package Autumn.C3_LinkedList;

import sun.awt.image.ImageWatched;

import java.util.IntSummaryStatistics;
import java.util.LinkedList;

/**
 * Created by HaoYu on 2017/10/2.
 */
public class QueueByTwoStacks {
    private LinkedList<Integer> in;
    private LinkedList<Integer> out;
    public QueueByTwoStacks() {
        // Write your solution here.
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    public Integer poll() {
        move();
        return out.pollFirst();
    }

    public void offer(int element) {
        in.offerFirst(element);
    }

    public Integer peek() {
        move();
        return out.peekFirst();
    }

    public int size() {
        return in.size() + out.size();
    }

    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
    }

    private void move(){
        if (out.isEmpty()) {
            while (!in.isEmpty()){
                out.offerFirst(in.pollFirst());
            }
        }
    }
}
