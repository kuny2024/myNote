package multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultiThread {
    // 单线程计算1到1000万的和
    // 多线程并行计算
        public static void main(String[] args) throws InterruptedException, ExecutionException {
            long start = System.currentTimeMillis();

            // 分成4个任务并行计算
            ExecutorService executor = Executors.newFixedThreadPool(4);
            List<Future<Long>> futures = new ArrayList<>();

            // 创建4个计算任务
            for (int i = 0; i < 4; i++) {
                int part = i;  // 保存当前分片索引

                // 创建Callable任务对象
                Callable<Long> task = new Callable<Long>() {
                    @Override
                    public Long call() throws Exception {
                        long sum = 0;
                        int startNum = part * 2500000 + 1;
                        int endNum = (part + 1) * 2500000;

                        for (int j = startNum; j <= endNum; j++) {
                            sum += j;
                        }

                        return sum;
                    }
                };

                // 提交任务到线程池
                futures.add(executor.submit(task));
            }

            long totalSum = 0;
            for (Future<Long> future : futures) {
                totalSum += future.get();
            }

            executor.shutdown();
            System.out.println("耗时：" + (System.currentTimeMillis() - start) + "ms");
        }
}
