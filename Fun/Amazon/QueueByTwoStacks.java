package Fun.Amazon;

import sun.awt.image.ImageWatched;

import java.util.Deque;
import java.util.LinkedList;

public class QueueByTwoStacks {

    private Deque<Integer> in;
    private Deque<Integer> out;

    public QueueByTwoStacks() {
        // Write your solution here.
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    public Integer poll() {
        move();
        return out.isEmpty() ? null : out.pollFirst();
    }

    public void offer(int element) {
        in.offerFirst(element);
    }

    public Integer peek() {
        move();
        return out.isEmpty() ? null : out.peekFirst();
    }

    public int size() {
        return in.size() + out.size();
    }

    public boolean isEmpty() {
        return in.size() == 0 && out.size() == 0;
    }

    private void move() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.offerFirst(in.pollFirst());
            }
        }
    }
}
