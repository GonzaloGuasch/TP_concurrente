import src.LatinPoisonPillException;

public class LatinWorker extends Thread {
    private final Buffer buffer;
    private final SortedList sortedList;
    private final CountDown countDown;

    public LatinWorker(Buffer buffer, SortedList list, CountDown countDown) {
        this.buffer = buffer;
        this.sortedList = list;
        this.countDown = countDown;
    }

    @SuppressWarnings("InfiniteLoopStatement")
    public void run() {
        try {
            while (true) {
                Object square = this.buffer.read();
                this.inspectSquare(square);
                this.countDown.dec();
            }
        } catch (LatinPoisonPillException latinPoisonPill) {
            System.out.println("I'm out of squares!");
        }
    }

    private void inspectSquare(Object square) throws LatinPoisonPillException {
        if (this.isLatinSquare(square)) {
            this.sortedList.add(-1);
        }
    }

    private boolean isLatinSquare(Object square) {
        return false;
    }
}
