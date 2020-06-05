package classes;

public class LatinWorker extends Thread {
    private final Buffer buffer;
    private final CountDown countDown;

    public LatinWorker(Buffer buffer, CountDown countDown) {
        this.buffer = buffer;
        this.countDown = countDown;
    }

    @SuppressWarnings("InfiniteLoopStatement")
    public void run() {
        try {
            while (true) {
                Runnable task = this.buffer.read();
                task.run();
                this.countDown.dec();
            }
        } catch (LatinPoisonPillException latinPoisonPill) {
            System.out.println("I'm out of squares!");
        }
    }
}
