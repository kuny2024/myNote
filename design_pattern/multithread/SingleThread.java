package multithread;

public class SingleThread {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long sum = 0;
        for (int i = 1; i <= 10000000; i++) {
            sum += i;
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - start) + "ms");
    }
}
