package create_thread;

public class TestThread extends Thread{
    @Override
    public void run () {
        for (int i = 0; i < 20; ++i) {
            System.out.println("I'm learning thread");
        }
    }

    public static void main(String[] args) {
        TestThread testThread1 = new TestThread();
        testThread1.start();
        for (int i = 0; i < 20; ++i) {
            System.out.println("I'm learning main");
        }
    }
}
