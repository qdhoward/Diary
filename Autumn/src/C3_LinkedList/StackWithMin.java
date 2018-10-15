package C3_LinkedList;

import sun.invoke.util.VerifyAccess;

import java.util.LinkedList;

/**
 * Created by HaoYu on 2017/10/2.
 */
public class StackWithMin {
    protected class pair{
        int key;
        int value;
        public pair(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private LinkedList<Integer> s1;
    private LinkedList<pair> s2;
    public StackWithMin(){
        s1 = new LinkedList<>();
        s2 = new LinkedList<>();
    }
    public int pop() {
        if(s1.isEmpty()){
            return -1;
        } else {
            if (s2.peekFirst().value > s1.size() - 1) {
                s2.pollFirst();
            }
            return s1.pollFirst();
        }
    }

    public void push(int element) {
        if(s1.isEmpty() || s2.peekFirst().key > element){
            s2.offerFirst(new pair(element, s1.size() + 1));
        }
        s1.offerFirst(element);
    }

    public int top() {
        if(s1.isEmpty()){
            return -1;
        } else {
            return s1.peekFirst();
        }
    }

    public int min() {
        if(s2.isEmpty()){
            return -1;
        } else {
            return s2.peekFirst().key;
        }
    }

    public static void main(String[] args){
        StackWithMin test = new StackWithMin();
        test.push(1);
        test.push(2);
        test.push(-1);
        test.push(3);
        test.pop();
        test.pop();
        System.out.println(test.min());
    }
}
