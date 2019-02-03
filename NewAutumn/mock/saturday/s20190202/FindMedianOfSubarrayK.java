package NewAutumn.mock.saturday.s20190202;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class FindMedianOfSubarrayK {
    class Element implements Comparable<Element>{
        int val;
        int index;

        Element(int val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public int compareTo(Element e) {
            if (e.val == this.val) {
                if (e.index == this.index) {
                    return 0;
                }
                return this.index < e.index ? -1 : 1;
            }
            return this.val < e.val ? -1 : 1;
        }

        @Override
        public int hashCode() {
            return this.index;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Element)) {
                return false;
            }
            Element another = (Element) obj;
            return this.val == another.val && this.index == another.index;
        }
    }
    public double[] getMedianArray(int[] array, int k) {
        TreeSet<Element> min = new TreeSet<>(Collections.reverseOrder());
        TreeSet<Element> max = new TreeSet<>();
        double[] res = new double[array.length - k + 1];
        for (int i = 0; i < array.length; i++) {
            if (i == 8) {
                System.out.println(111);
            }
            Element cur = new Element(array[i], i);
            if (min.isEmpty() || cur.val <= min.first().val) {
                min.add(cur);
            } else {
                max.add(cur);
            }
            if (i >= k) {
                Element remove = new Element(array[i - k], i - k);
                min.remove(remove);
                max.remove(remove);
            }

            if (min.size() - max.size() >= 2) {
                Element minMax = min.first();
                max.add(minMax);
                min.remove(minMax);
            } else if (max.size() > min.size()) {
                Element maxMin = max.first();
                min.add(maxMin);
                max.remove(maxMin);
            }
            if (i >= k - 1) {
                if ((max.size() + min.size()) % 2 == 0) {
                    res[i - k + 1] = (max.first().val + min.first().val) / 2.0;
                } else {
                    res[i - k + 1] = (double) min.first().val;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindMedianOfSubarrayK().getMedianArray(new int[] {2,3,8,9,10,1,2,3,1,2}, 5)));
    }
}
