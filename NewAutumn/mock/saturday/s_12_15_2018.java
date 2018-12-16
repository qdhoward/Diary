package NewAutumn.mock.saturday;
import util.NestedInteger;

import java.util.*;

public class s_12_15_2018 {
    //Q1 Time(number of stops) Space(number of routes)
    class Point {
        int x;
        int y;
        int cost;
        public Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    public int leastBus(int[][] routes, int start, int end) {
        //Assuming start is in the first route
        Map<Integer, Set<Point>> indexMap = buildIndexMap(routes);
        int startIndex = -1;
        for (int i = 0; i < routes[0].length; i++) {
            if (routes[0][i] == start) {
                startIndex = i;
            }
        }
        Queue<Point> queue = new LinkedList<>();
        Set<Integer> visitedRoute = new HashSet<>();
        queue.offer(new Point(0, startIndex, 1));
        visitedRoute.add(0);
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int i = 0; i < routes[cur.x].length; i++) {
                if (routes[cur.x][i] == end) {
                    return cur.cost;
                }
                Set<Point> nextRoute = indexMap.get(routes[cur.x][i]);
                if (nextRoute.size() > 0) {
                    for (Point p : nextRoute) {
                        if (!visitedRoute.contains(p.x)) {
                            p.cost = cur.cost + 1;
                            queue.offer(p);
                        }
                    }
                }
            }
        }
        return -1;
    }
    private Map<Integer, Set<Point>> buildIndexMap(int[][] routes) {
        Map<Integer, Set<Point>> index = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                if (!index.containsKey(routes[i][j])) {
                    index.put(routes[i][j], new HashSet<>());
                } else {
                    index.get(routes[i][j]).add(new Point(i, j, 0));
                }

            }
        }
        return index;
    }

    //Q2 https://leetcode.com/problems/nested-list-weight-sum-ii/description/
    public int depthSumInverse(List<NestedInteger> nestedList) {
        return getnestedListSum(nestedList, getDepth(nestedList));
    }

    private int getnestedListSum(List<NestedInteger> nestedList, int depth) {
        int res = 0;
        for (NestedInteger ne : nestedList) {
            if (ne.isInteger()) {
                res += depth * ne.getInteger();
            } else {
                res += getnestedListSum(ne.getList(), depth - 1);
            }
        }
        return res;
    }

    private int getDepth (List<NestedInteger> nestedList) {
        int res = 1;
        for (NestedInteger ne : nestedList) {
            if (!ne.isInteger()) {
                res = Math.max(res, getDepth(ne.getList()) + 1);
            }
        }
        return res;
    }

    //Q4 TODO 实现在Fun/PickPassenger.java



    public static void main(String[] args) {
        s_12_15_2018 test = new s_12_15_2018();
        System.out.println(test.leastBus(new int[][] {
                {1,4,5,9},
                {2,6,7,9}
        }, 4 ,7));
    }
}
