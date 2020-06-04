import src.LatinPoisonPill;
import src.LatinPoisonPillException;

public class LatinWorker extends Thread{
    private Buffer buffer;
    private SortedList sortedList;
    private CountDown countDown;

    public LatinWorker(Buffer buffer){
        this.buffer = buffer;
    }

    public LatinWorker(Buffer buffer, SortedList sortedLit, CountDown countDown) {
        this.buffer = buffer;
        this.sortedList = sortedList;
        this.countDown = countDown;
    }

    public void run(){
        try{
            while(true){
                //Busco un cuadrado latino del buffer
                //if(this.esCuadradoLatino(cuadradoDeBuffer){ lo agrego a la sorted list}
                //decremento el countDown
            }
        }catch (LatinPoisonPillException latinPoisonPill){
            System.out.println("Ya no tengo mas cuadrados latinos!");
        }
    }

    private boolean esLatinSquare(Object cuadradoLatino){
     return false;
    }
}
