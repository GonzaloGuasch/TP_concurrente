package classes;

import java.io.*;

public class ThreadPool {
    private final Buffer buffer;
    private final Integer amountOfLatinWorkers;
    private final CountDown countDown;
    public final SortedList sortedList;

    public ThreadPool(Buffer buffer, Integer amountOfLatinWorkers) {
        this.sortedList = new SortedList();
        this.countDown = new CountDown(10); //cantidad de cuadrados latinos
        this.buffer = buffer;
        this.amountOfLatinWorkers = amountOfLatinWorkers;
        for (int i = 0; i < amountOfLatinWorkers; i++) {
            new LatinWorker(this.buffer, countDown).start();
        }
    }

    public void launch() throws IOException {  //escribo en el buffer
        File file = new File("./src/lib/inputs-ejemplo.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int amountOfSquares = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= amountOfSquares; i++) {
            Square square = new Square(reader.readLine());
            this.buffer.write(new SquareTask(square, this.sortedList));
        }
        this.stop();
    }

    public void stop() {
        for (int i = 0; i < this.amountOfLatinWorkers; i++) {
            this.buffer.write(new LatinPoisonPill());
        }
        this.countDown.zero();
        System.out.println(this.sortedList.toString());
    }
}
