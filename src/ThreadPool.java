import src.LatinPoisonPill;

public class ThreadPool {
    private final Buffer buffer;
    private final Integer amountOfLatinWorkers;

    public ThreadPool(Buffer buffer, Integer amountOfLatinWorkers) {
        SortedList list = new SortedList();
        CountDown countDown = new CountDown(1000); //cantidad de cuadrados latinos
        this.buffer = buffer;
        this.amountOfLatinWorkers = amountOfLatinWorkers;
        for (int i = 0; i < amountOfLatinWorkers; i++) {
            new LatinWorker(this.buffer, list, countDown).start();
        }
    }

    public void launch() {  //escribo en el buffer
        //this.buffer.write();
    }

    public void stop() {
        for (int i = 0; i < this.amountOfLatinWorkers; i++) {
            this.buffer.write(new LatinPoisonPill());
        }
    }

}
