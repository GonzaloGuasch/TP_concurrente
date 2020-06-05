import classes.Buffer;
import classes.ThreadPool;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        //cuadrados de input
        Buffer buffer = new Buffer(10);
        ThreadPool threadPool = new ThreadPool(buffer, 10);

        threadPool.launch();
    }
}
