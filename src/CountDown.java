public class CountDown {
    private Integer value;

    public CountDown(Integer value){
        this.value = value;
    }

    public synchronized void dec(){
        this.value = this.value--;
    }

    public synchronized void zero(){
        while(!this.isCero()){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        notifyAll();
    }

    private boolean isCero(){
        return this.value <= 0;
    }
}
