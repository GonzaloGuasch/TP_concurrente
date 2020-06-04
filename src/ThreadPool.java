import src.LatinPoisonPill;

public class ThreadPool {
    private Buffer buffer;
    private Integer amountOfLatinWorkers;

    public ThreadPool(Buffer buffer, Integer amountOfLatinWorkers) {
        this.buffer = buffer;
        this.amountOfLatinWorkers = amountOfLatinWorkers;
        for (int i = 0; i < amountOfLatinWorkers; i++) {
            new LatinWorker().start();
        }

    }

        public void stop(){
            for(int i = 0; i < this.amountOfLatinWorkers ; i++){
                this.buffer.write(new LatinPoisonPill());
            }
        }

}
