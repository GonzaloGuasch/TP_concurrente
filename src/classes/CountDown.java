package classes;

public class CountDown {
    private Integer value;

    public CountDown(Integer value) {
        this.value = value;
    }

    public synchronized void dec() {
        this.value--;
    }

    public synchronized void zero() {
        while(this.isLocking()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
    }

    private boolean isLocking() {
        return this.value > 0;
    }
}
