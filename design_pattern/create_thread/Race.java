package create_thread;

public class Race implements Runnable{
    private static String winner;
    @Override
    public void run() {
        for (int i = 0; i <= 100; ++i) {
            if (gameOver(i)) {
                break;
            }
            if (Thread.currentThread().getName().equals("Rabbit") && i % 10 == 0 && i > 0) {
                try{
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " Run Steps " + i);
        }
    }

    //判断比赛是否结束
    private boolean gameOver(int steps) {
        if (winner != null) {
            return true;
        } else if (steps >= 100) {
            winner = Thread.currentThread().getName();
            System.out.println("winner is " + winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race, "Rabbit").start();
        new Thread(race, "Turtle").start();
    }
}
