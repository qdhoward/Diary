package LeetCode.Topic.Array;

import util.Interval;

import java.util.*;

public class MergeIntervals56 {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return new ArrayList<>();
        }
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) {
                    return 0;
                }
                return o1.start < o2.start ? -1 : 1;
            }
        });
        List<Interval> res = new ArrayList<>();
        res.add(intervals.get(0));
        for (int i = 1; i < intervals.size() - 1; i++) {
            if (intervals.get(i).start <= res.get(res.size() - 1).end) {
                if (intervals.get(i).end > res.get(res.size() - 1).end) {
                    res.get(res.size() - 1).end = intervals.get(i + 1).end;
                }
            } else {
                res.add(intervals.get(i));
            }
        }
        return res;
    }
}
