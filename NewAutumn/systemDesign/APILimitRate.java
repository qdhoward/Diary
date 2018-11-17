package NewAutumn.systemDesign;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class APILimitRate {
    private static Map<Integer, Queue<Integer>> record = new HashMap<>();
    private static final int size = 100;
    private static final int gap = 1000;//Millisecond

    public boolean isAllowed(Integer clintId, Integer request) {
        Queue<Integer> queue = record.get(clintId);
        if (queue == null) {
            record.put(clintId, new LinkedList<>());
            return true;
        } else {
            if (queue.size() < size) {
                queue.offer(request);
                return true;
            } else {
                if (request - queue.peek() > gap) {
                    queue.poll();
                    queue.offer(request);
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
}
