package NewAutumn.mock.saturday.s20190202;

public class SquareRootOfInteger {
    public int squre(int num) {
        if (num <= 0) {
            return 0;
        }
        int left = 1;
        int right = 1;
        while (right < num) {
            if (num / right == right) {
                return right;
            } else if (right < num / right) {
                left = right;
                right = 2 * right;
            } else {
                break;
            }
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (num / mid == mid) {
                return mid;
            } else if (mid > num / mid) {
                right = mid;
            } else {
                if ((mid + 1) > num / (mid + 1)) {
                    return mid;
                }
                left = mid;
            }
        }
        return left;
    }

    public int square2(int num) {
        if (num <= 0) {
            return 0;
        }
        int left = 1;
        int right = num;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (num / mid == mid) {
                return mid;
            } else if (mid < num / mid) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return num / right >= right ? right : left;
    }


    public static void main(String[] args) {
        System.out.println(new SquareRootOfInteger().square2(2));
    }
}