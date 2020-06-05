package classes;

public class SquareTask implements Runnable {

    private final Square square;
    private final SortedList sortedList;
    private final Integer arrayPosition;

    public SquareTask(Square square, Integer arrayPosition, SortedList sortedList) {
        this.square = square;
        this.arrayPosition = arrayPosition;
        this.sortedList = sortedList;
    }

    @Override
    public void run() {
        if (square.isLatinSquare()) {
            this.sortedList.add(arrayPosition);
        }
    }
}
