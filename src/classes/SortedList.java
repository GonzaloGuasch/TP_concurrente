package classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortedList {
    private final List<Integer> elements = new ArrayList<>();

    public synchronized void add(Integer integerToAdd) {
        this.elements.add(integerToAdd);
        Collections.sort(this.elements);
    }

    public synchronized Integer get(Integer index) {
        return this.elements.get(index);
    }

    @Override
    public String toString() {
        return this.elements.toString();
    }
}
