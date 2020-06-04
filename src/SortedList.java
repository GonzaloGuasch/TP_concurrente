import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortedList {
    private List<Integer> sortedList = new ArrayList<Integer>();


    public synchronized void add(Integer integerToAdd){
        this.sortedList.add(integerToAdd);
        Collections.sort(this.sortedList);
    }

}
