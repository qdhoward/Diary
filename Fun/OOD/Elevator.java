package Fun.OOD;

import java.util.Queue;

public class Elevator {
    public static final int DEFAULT_ELEVATOR_MAX_CAPACITY = 14;
    public static final int DEFAULT_ELEVATOR_MAX_FLOOR = 10;
    public static final int DEFAULT_INITIAL_LOCATION = 1;

    private final int maxCapacity;
    private final int maxFloor;
    private int load;
    private int location;
    private boolean isGoingUp;

    private int[] request;

    public Elevator (int maxCapacity, int maxFloor) {
        this.maxCapacity = maxCapacity;
        this.maxFloor = maxFloor;
        load = 0;
        location = DEFAULT_INITIAL_LOCATION;
        isGoingUp = true;
        request = new int[maxFloor];
    }

    public Elevator() {
        this(DEFAULT_ELEVATOR_MAX_CAPACITY, DEFAULT_ELEVATOR_MAX_FLOOR);
    }

    public boolean isEmpty() {
        return load == 0;
    }

    public boolean isFull() {
        return load >= maxCapacity;
    }

    public int getLocation() {
        return location;
    }

    public int move() {
        if (isGoingUp) {
            return location + 1 <= maxFloor ? ++location : location;
        } else {
            return location - 1 >= 0 ? --location : location;
        }
    }

    public boolean changeMovingDirection() {
        isGoingUp = !isGoingUp;
        return isGoingUp;
    }

    public int load(Queue<Integer> curQueue) {
        int numNewLoad = curQueue.size();
        if (load + numNewLoad > maxCapacity) {
            return 0;
        }

        for (int requestedFloor : curQueue) {
            request[requestedFloor - 1] += 1;
        }

        load += numNewLoad;
        curQueue.clear();
        return numNewLoad;

    }

    public int unLoad() {
        return 0;
    }


}
