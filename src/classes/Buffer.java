package classes;

public class Buffer {
    private final Runnable[] queue;
    private final Integer n;
    private Integer end;
    private Integer start;

    public Buffer(Integer size) {
        this.start = 0;
        this.end = size - 1;
        this.n = size;
        this.queue = new Runnable[size];
    }

    public synchronized void write(Runnable writable) {
        while(this.isFull()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.queue[this.start] = writable;
        this.start = this.next(this.start);
        notifyAll();
    }

    public synchronized Runnable read() {
        while(this.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Runnable retrieved = this.queue[this.end];
        this.end = this.next(this.end);
        notifyAll();
        return retrieved;
    }

    private boolean isEmpty() {
        return this.start.equals(this.end);
    }

    private boolean isFull() {
        return next(this.start) == end;
    }

    private int next(int i) {
        return (i+1)%(this.n+1);
    }
}


