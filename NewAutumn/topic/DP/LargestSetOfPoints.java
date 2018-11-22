package NewAutumn.topic.DP;

import util.Point;

import java.util.Arrays;
import java.util.Comparator;

public class LargestSetOfPoints {
    public int largest(Point[] points) {
        // Write your solution here.
        //
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.x < o2.x) {
                    return -1;
                } else {
                    if (o1.x == o2.x) {
                        if (o1.y == o2.y) {
                            return 0;
                        }
                        return o1.y > o2.y ? -1 : 1;
                    }
                }
                return 1;
            }
        });
        int result = 0;
        int[] refine = new int[points.length];
        refine[0] = points[0].y;//TODO 初始值是第一个元素！
        for (int i = 0; i < points.length; i++) {
            int index = findLargestSmaller(refine, 0, result, points[i].y);
            if (index == result) {
                refine[++result] = points[i].y;
            } else {
                refine[index + 1] = points[i].y;
            }
        }
        if (result == 0) {
            return 0;//TODO 要考虑最长增序子序列结果为1的时候
        }
        return result + 1;
    }

    private int findLargestSmaller(int[] array, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
