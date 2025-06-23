package create_thread;

public class TestLambda2 {
    public static void main(String[] args) {
        ILove love = (a) -> {
            System.out.println("I love you " + a);
        };

        love.love(520);

        ILove love2 = a -> {
            System.out.println("I love you " + a);
        };
        love2.love(520);

        //只有一行时，可以省略花括号
        ILove love3 = a -> System.out.println("I love you " + a);
        love3.love(520);
    }
}

//函数式接口（只有一个方法）
interface ILove{
    void love(int a);
}
