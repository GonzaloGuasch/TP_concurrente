import classes.Buffer;
import classes.Input;
import classes.ThreadPool;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        Input input = new Input();

        Buffer buffer = new Buffer(input.tamBuffer());
        ThreadPool threadPool = new ThreadPool(buffer, input.amountOfLatinWorkers());

        threadPool.launch();
    }
}
