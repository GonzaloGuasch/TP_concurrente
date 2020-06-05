package classes;

public class SquareTask implements Runnable {

    private final Square square;
    private final SortedList sortedList;

    public SquareTask(Square square, SortedList sortedList) {
        this.square = square;
        this.sortedList = sortedList;
    }

    @Override
    public void run() {
        this.inspectSquare();
    }

    private void inspectSquare() throws LatinPoisonPillException {
        if (this.isLatinSquare()) {
            this.sortedList.add(-1);
        }
    }

    private boolean isLatinSquare() {
        return false;
    }
}
