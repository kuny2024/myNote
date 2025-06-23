package thread_state;

public class TestJoin implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 1000; ++i) {
            System.out.println("Thread VIP is coming " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        for (int i = 0; i < 500; ++i) {
            if (i == 100) {
                //保证子线程跑完
                thread.join();
            }
            System.out.println("main" + i);
        }
    }
}
