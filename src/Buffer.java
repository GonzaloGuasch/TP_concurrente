public class Buffer {
    private Object[] data;
    private Integer n;
    private Integer end;
    private Integer start;

    public Buffer(Integer tam){
        this.n = tam;
        this.data = new Object[tam];
    }

    public synchronized void write(Object objectToWrite){
        while(this.isFull()){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.data[this.start] = objectToWrite;
        this.start = this.next(this.start);
        notifyAll();

    }

    public synchronized Object read(Object objectoToRead){
        while(this.isEmpty()){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
        Object objectToReturn = this.data[this.end];
        this.end = this.next(this.end);
        notifyAll();
        return objectToReturn;
    }

    private boolean isEmpty(){
        return this.start.equals(this.end);
    }
    private boolean isFull(){
        return next(this.start) == end;
    }
    private int next(int i){
        return (i+1)%(this.n+1);
    }
}


