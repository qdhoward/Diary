package LeetCode.Facebook;

import util.Interval;

import java.util.Arrays;

public class MeetingRoomsII253 {
    public int minMeetingRooms(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int endsItr = 0;
        for (int i = 0; i < starts.length; i++) {
            if (starts[i] < ends[endsItr])
                rooms++;
            else
                endsItr++;
        }
        return rooms;
    }
//    public int minMeetingRooms(Interval[] intervals) {
//        if (intervals.length == 0) {
//            return 0;
//        }
//        int[] parent = new int[intervals.length];
//        int[] rank = new int[intervals.length];
//        parent[0] = -1;
//        for (int i = 1; i < intervals.length; i++) {
//            parent[i] = -1;
//            for (int j = 0; j < i; j++) {
//                if (intervals[i].start >= intervals[j].end || intervals[i].end <= intervals[j].start) {
//                    safeUnion(parent, rank, i, j);
//                }
//            }
//        }
//        int res = 0;
//        for (int i = 0; i < intervals.length; i++) {
//            if (parent[i] == -1) {
//                res += 1;
//            }
//        }
//        return res;
//    }
//
//    private void union(int[] parent, int[] rank, int i, int j) {
//        if (rank[i] > rank[j]) {
//            int tmp = i;
//            i = j;
//            j = tmp;
//        }
//        if (rank[i] == rank[j]) {
//            rank[j]++;
//        }
//        parent[i] = j;
//    }
//
//    private int find(int[] parent, int i) {
//        if (parent[i] == -1) {
//            return i;
//        }
//        parent[i] = find(parent, parent[i]);
//        return parent[i];
//    }
//
//    private void safeUnion(int[] parent, int[] rank, int i, int j) {
//        int a = find(parent, i);
//        int b = find(parent, j);
//        if (a != b || a == -1) {
//            union(parent, rank, a, b);
//        }
//    }
}
