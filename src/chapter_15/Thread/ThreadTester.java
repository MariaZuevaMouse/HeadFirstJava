package chapter_15.Thread;

public class ThreadTester {
    public static void main(String[] args) {
        Runnable threadJobb = new MyRunnable();
        Thread myThread = new Thread(threadJobb);
        myThread.start();
        System.out.println("back to main");
    }
}
