import classes.Buffer;
import classes.Input;
import classes.ThreadPool;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Input input = new Input();

        long startTime = System.nanoTime();
        Buffer buffer = new Buffer(input.tamBuffer());
        ThreadPool threadPool = new ThreadPool(buffer, input.amountOfLatinWorkers());

        threadPool.launch();
        long endTime = System.nanoTime();

        Thread.sleep(300);
        System.out.println("Tiempo de ejecucion: " + ((endTime - startTime) / 1000000000) + " Segundos");
    }
}
