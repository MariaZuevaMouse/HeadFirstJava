package chapter_15.home;

public class TestTreads {
    public static void main(String[] args) {
        TreadTwo t2  = new TreadTwo();
        Thread two = new Thread(t2);

        TreadOne t1  = new TreadOne();
        Thread one  = new Thread(t1);

        one.start();
        two.start();
    }
}
class Accum{
    private static Accum a = new Accum();
    private int counter = 0;
    private Accum(){}

    public static Accum getAccum(){
        return a;
    }
    public void updateCounter(int add){
        counter += add;
    }
    public int getCount(){
        return counter;
    }
}
class TreadOne implements Runnable{
    Accum a  = Accum.getAccum();
    public void run(){
        for(int x = 0; x<98; x++){
            a.updateCounter(1000);
            try{
                Thread.sleep(50);
            }catch (InterruptedException ex){ex.printStackTrace();}
        }
        System.out.println("one " + a.getCount());
    }
}
class TreadTwo implements Runnable{
    Accum a  = Accum.getAccum();
    public void run(){
        for(int x = 0; x<99; x++){
            a.updateCounter(1);
            try{
                Thread.sleep(50);
            }catch (InterruptedException ex){ex.printStackTrace();}
        }
        System.out.println("one " + a.getCount());
    }
}
