package se.mspi.lab3;

import java.util.LinkedList;
import java.util.List;

public class ShotHistory {
    List<Shot> history = new LinkedList<>();

    public void addShot(Shot shot) {
        history.add(shot);
    }

    public List<Shot> getHistory() {
        return history;
    }
}
