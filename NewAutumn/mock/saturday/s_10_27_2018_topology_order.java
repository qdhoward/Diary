package NewAutumn.mock.saturday;

import java.util.*;

public class s_10_27_2018_topology_order {
    class Task {
        List<Task> tasks; //Dependencies
    }
    //TODO 拓扑排序 判断是否是个Directed Acyclic Graph（DAG）
    public boolean iaValid(List<Task> tasks) {
        Deque<Task> queue = new LinkedList<>();
        Map<Task, Integer> incoming = new HashMap<>();//入度
        Map<Task, List<Task>> downsteamTasks = new HashMap<>();//value depends on key
        for (Task t: tasks) {
            for(Task dep: t.tasks) {
                if (!downsteamTasks.containsKey(dep)) {
                    downsteamTasks.put(dep, new ArrayList<>());
                }
                downsteamTasks.get(dep).add(t);
            }
            incoming.put(t, t.tasks.size());
            if (t.tasks.size() == 0) {
                queue.addLast(t);//入度为0的点压入
            }
        }
        List<Task> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            Task task = queue.getFirst();
            res.add(task);
            for (Task child: downsteamTasks.getOrDefault(task, new ArrayList<>())) {
                incoming.put(child, incoming.get(child) - 1);
                if (incoming.get(child) == 0) {
                    queue.addLast(child);
                }
            }
        }
        return res.size() == tasks.size();
    }
}
