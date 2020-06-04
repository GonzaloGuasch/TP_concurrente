import src.LatinPoisonPill;

public class ThreadPool {
    private Buffer buffer;
    private Integer amountOfLatinWorkers;
    private SortedList sortedLit;
    private CountDown countDown;

    public ThreadPool(Buffer buffer, Integer amountOfLatinWorkers) {
        this.sortedLit = new SortedList();
        this.countDown = new CountDown(1000); //cantidad de cuadrados latinos
        this.buffer = buffer;
        this.amountOfLatinWorkers = amountOfLatinWorkers;
        for (int i = 0; i < amountOfLatinWorkers; i++) {
            new LatinWorker(this.buffer, sortedLit, countDown).start();
        }

    }

        public void stop(){
            for(int i = 0; i < this.amountOfLatinWorkers ; i++){
                this.buffer.write(new LatinPoisonPill());
            }
        }

}
