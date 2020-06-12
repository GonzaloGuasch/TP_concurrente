import classes.Buffer;
import classes.Input;
import classes.ThreadPool;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Input input = new Input();

        Buffer buffer = new Buffer(input.tamBuffer());
        ThreadPool threadPool = new ThreadPool(buffer, input.amountOfLatinWorkers());
        long startTime = System.currentTimeMillis();
        threadPool.launch();
        long endTime = System.currentTimeMillis();

        System.out.println("Tiempo de ejecucion: " + ((endTime - startTime)) + " Milisegundos");
    }
}
