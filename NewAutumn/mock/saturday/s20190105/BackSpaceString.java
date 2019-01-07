package NewAutumn.mock.saturday.s20190105;

public class BackSpaceString {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;
        while( i >= 0 || j >= 0){
            while(i >= 0){
                if (S.charAt(i) == '#'){
                    skipS++;
                    i--;
                }
                else if (skipS >0){
                    skipS--;
                    i--;
                }
                else{
                    break;
                }
            }
            while(j >= 0){
                if (T.charAt(j) == '#'){
                    skipT++;
                    j--;
                }
                else if (skipT > 0){
                    j--;
                    skipT--;
                }
                else{
                    break;
                }
            }
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)){
                return false;
            }
            if((i >= 0) != (j >=0)){
                return false;
            }
            i--;
            j--;
        }
        return true;
    }


    public boolean deleteBackSpace(String s1, String s2) {
        //从右向左扫一遍
        if (s1 == null && s2 == null) {
            return true;
        } else if (s1 == null || s2 == null) {
            return false;
        } else if (s1.length() == 0 && s2.length() == 0) {
            return true;
        }

        int pointer1 = s1.length() - 1;
        int pointer2 = s2.length() - 1;
        int count = 0;
        while (pointer1 != 0 || pointer2 != 0) {
            if (s1.charAt(pointer1) == '\\') {
                while (s1.charAt(pointer1) == '\\') {
                    count++;
                    pointer1--;
                }
                pointer1 -= count;
            } else if (s2.charAt(pointer2) == '\\') {
                while (s2.charAt(pointer2) == '\\') {
                    count++;
                    pointer2--;
                }
                pointer2 -= count;
            } else if (s1.charAt(pointer1) != s2.charAt(pointer2)) {
                return false;
            } else {
                //To avoid index out of boundary
                pointer1 = pointer1 == 0 ? 0 : pointer1 - 1;
                pointer2 = pointer2 == 0 ? 0 : pointer2 - 1;
            }
            count = 0;
        }
        return true;
    }

    public boolean deleteBackSpace2(String s1, String s2) {
        //从右向左扫一遍
        if (s1 == null && s2 == null) {
            return true;
        } else if (s1 == null || s2 == null) {
            return false;
        } else if (s1.length() == 0 && s2.length() == 0) {
            return true;
        }

        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();
        int slow = helper(array1);
        helper(array2);
        while (slow >= 0) {
            if (array1[slow] != array2[slow]) {
                return false;
            }
            slow--;
        }
        return true;
    }

    private int helper(char[] array) {
        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            if (array[fast] == '\\') {
                if (slow != 0) {
                    slow--;
                }
                fast++;
            } else {
                array[slow++] = array[fast++];
            }
        }
        return slow - 1;
    }

    public static void main(String[] args) {
        System.out.println(new BackSpaceString().deleteBackSpace2("aaa\\b\\cg", "aa\\\\ad\\cg"));
    }
}
