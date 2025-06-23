package create_thread;

//实现Runnable接口，允许多个进程同时处理一个对象
//问题：1. 输出并没有按照ticket10->0，因为打印顺序不等于执行顺序
//问题：2. 多个线程操作同一个资源，线程不安全，数据不一致
public class TestThread3 implements Runnable{
    private int tickets = 10;
    @Override
    public void run() {
        while (true) {
             if (tickets <= 0) {
                break;
            }

             //延时
            try{
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--> get ticket " + tickets--);
        }
    }

    public static void main(String[] args) {
        TestThread3 testThread3 = new TestThread3();
        new Thread(testThread3, "Benny").start();
        new Thread(testThread3, "Harry").start();
        new Thread(testThread3, "Joel").start();
    }
}
/*
Benny--> get ticket 10
Joel--> get ticket 8
Harry--> get ticket 9
Benny--> get ticket 7
Joel--> get ticket 6
Harry--> get ticket 5
Benny--> get ticket 4
Harry--> get ticket 3
Joel--> get ticket 4
Harry--> get ticket 2
Joel--> get ticket 2
Benny--> get ticket 1
Harry--> get ticket 0
Joel--> get ticket -1

 */