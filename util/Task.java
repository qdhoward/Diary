package util;

import java.util.ArrayList;
import java.util.List;

public class Task {
    public List<Task> dependency;
    public int time;
    public String name;
    public Task(String name, int time) {
        this.dependency = new ArrayList<>();
        this.time = time;
        this.name = name;
    }
}
