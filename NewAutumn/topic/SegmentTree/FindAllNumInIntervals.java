package NewAutumn.topic.SegmentTree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FindAllNumInIntervals {

        static class Interval{
            int start, end;
            public Interval(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }

        public static void main(String[] args) {
            Interval a1 = new Interval(0,8);
            Interval a2 = new Interval(2,6);
            Interval a3 = new Interval(7,14);
            Interval a4 = new Interval(15,19);
            List<Interval> test = new ArrayList<>();
            test.add(a1);
            test.add(a2);
            test.add(a3);
            test.add(a4);
            List<Integer> num = new ArrayList<>();
            num.add(-1);
            num.add(2);
            num.add(7);
            num.add(10);
            num.add(20);
            num.add(4);
            num.add(1);

            Collections.sort(num);
            Map <Integer, Integer> map = new TreeMap<>();
            for(int i = 0; i < num.size(); i++) {
                map.put(num.get(i), i);
            }
            List<List<Integer>> res = new ArrayList<>();
            for(int i = 0; i < test.size(); i++) {
                List<Integer> par = new ArrayList<>();
                Integer low = ((TreeMap<Integer, Integer>) map).ceilingKey(test.get(i).start);
                Integer high = ((TreeMap<Integer, Integer>) map).floorKey(test.get(i).end);
                if (high != null && low != null) {
                    int start = map.get(low);
                    int end = map.get(high);
                    for(int j = start; j <= end; j++) {
                        par.add(num.get(j));
                    }
                }
                else if (high == null && low == null) {
                    par.add(Integer.MIN_VALUE);
                }
                else if (high == null) {
                    par.add(low);
                }
                else {
                    par.add(high);
                }
                int len = par.size();
                for(int j = 0; j < len; j++) {
                    System.out.println(par.get(j));
                }
                System.out.println("\n");
                res.add(par);

            }


        }
}
