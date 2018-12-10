package NewAutumn.mock.saturday;

import util.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class s_12_08_2018 {
    public List<Integer> findNumber(int n) {
        List<Integer> res = new ArrayList<>();
        if (n <= 1) {
            return res;
        }
        int[] count = new int[n + 1];
        for (int i = 1; i * i <= n; i++) {
            for (int j = i; j *j <= n; j++) {
                int num = i * i + j * j;
                if (num <= n) count[num] += 1;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 2) {
                res.add(count[i]);
            }
        }
        return res;
    }

    public int getTime(List<Task> tasks) {
        int res = Integer.MIN_VALUE;
        Map<String, Integer> completedTime = new HashMap<>();
        for (Task task : tasks) {
            res = Math.max(helper(task, completedTime), res);
        }
        return res;
    }

    private int helper(Task task, Map<String, Integer> completedTime) {
        if (task.dependency.size() == 0) {
            return task.time;
        }
        Integer time = completedTime.get(task.name);
        if (time != null) {
            return time;
        }
        int maxTime = Integer.MIN_VALUE;
        for (Task dep: task.dependency) {
            maxTime = Math.max(helper(dep, completedTime), maxTime);
        }
        maxTime += task.time;
        completedTime.put(task.name, maxTime);
        return maxTime;
    }

    public static void main(String[] args) {
        Task c = new Task("c",3);
        Task d = new Task("d",4);
        Task e = new Task("e",5);
        Task a = new Task("a",2);
        Task b = new Task("b",1);
        Task x = new Task("x",3);
        Task y = new Task("y",4);
        Task z = new Task("z",8);
        c.dependency.add(a);
        c.dependency.add(b);
        d.dependency.add(a);
        d.dependency.add(b);
        a.dependency.add(x);
        a.dependency.add(y);
        b.dependency.add(z);
        e.dependency.add(b);
        List<Task> input = new ArrayList<>();
        input.add(c);
        input.add(d);
        input.add(e);
        input.add(a);
        input.add(b);
        input.add(x);
        input.add(y);
        input.add(z);
        System.out.println(new s_12_08_2018().getTime(input));
    }
}
