package create_thread;

public class TestThread2 implements Runnable{
    @Override
    public void run () {
        for (int i = 0; i < 20; ++i) {
            System.out.println("I'm learning thread");
        }
    }

    public static void main(String[] args) {
        TestThread testThread2 = new TestThread();

        //创建线程对象，通过线程对象来开启线程，代理
        new Thread(testThread2).start();

        for (int i = 0; i < 20; ++i) {
            System.out.println("I'm learning main");
        }
    }
}
