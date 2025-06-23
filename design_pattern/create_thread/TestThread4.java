package create_thread;

import java.util.concurrent.*;

/*
Callable：可以定义返回值，可以抛出异常
 */
public class TestThread4 implements Callable<Boolean> {
    @Override
    public Boolean call () {
        for (int i = 0; i < 20; ++i) {
            System.out.println("I'm learning thread");
        }
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestThread4 test1 = new TestThread4();
        TestThread4 test2 = new TestThread4();
        TestThread4 test3 = new TestThread4();

        //创建线程池
        ExecutorService service = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> r1 = service.submit(test1);
        Future<Boolean> r2 = service.submit(test1);
        Future<Boolean> r3 = service.submit(test1);

        for (int i = 0; i < 20; ++i) {
            System.out.println("I'm learning main");
        }

        //获取结果，阻塞主线程，如果任务还没完成，当前线程会等待直到任务完成
        boolean res1 = r1.get();
        boolean res2 = r2.get();
        boolean res3 = r3.get();

        //关闭服务
        service.shutdown();
    }
}
