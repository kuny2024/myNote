package thread_state;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSleep {
    public static void main(String[] args) {
        //倒计时
        try {
            tenDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //打印当前系统时间
        while (true) {
            try{
                Date startTime = new Date(System.currentTimeMillis());
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    //倒计时
    public static void tenDown() throws InterruptedException {
        int num = 10;
        while (true) {
            Thread.sleep(1000);
            System.out.println(num--);
            if (num <= 0) {
                break;
            }
        }
    }
}