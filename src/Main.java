public class Main {

    public static void main(String[] args){
        //cuadrados de input
        Buffer buffer = new Buffer(10);
        ThreadPool threadPool = new ThreadPool(buffer, 10);
    }
}
