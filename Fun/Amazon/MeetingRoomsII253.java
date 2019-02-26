package Fun.Amazon;

import util.Interval;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII253 {
    class Point {
        int val;
        boolean isStart;
        Point(int val, boolean isStart) {
            this.val = val;
            this.isStart = isStart;
        }
    }
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.val == o2.val) {
                    if (o1.isStart && o2.isStart) {
                        return 0;
                    }
                    return o1.isStart ? 1 : -1;
                }//TODO 注意(0,11], [11,13) end的要靠前！！！
                return o1.val < o2.val ? -1 : 1;
            }
        });
        for (Interval i : intervals) {
            pq.offer(new Point(i.start, true));
            pq.offer(new Point(i.end, false));
        }
        int res = 0;
        int count = 0;
        while (!pq.isEmpty()) {
            Point current = pq.poll();
            if (current.isStart) {
                count++;
            } else {
                count--;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
