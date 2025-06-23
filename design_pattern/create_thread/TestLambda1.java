package create_thread;

public class TestLambda1 {
    //静态内部类
    static class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("I like lambda2");
        }
    }
    public static void main(String[] args) {
        //1. 普通方法
        ILike like = new Like();
        like.lambda();

        //2. 静态内部类
        like = new Like2();
        like.lambda();

        //3. 局部内部类
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("I like lambda3");
            }
        }

        like = new Like3();
        like.lambda();

        //4.匿名内部类，没有类的名称，必须借助接口或者父类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I like lambda4");
            }
        };

        like.lambda();

        //lambda
        ILike like2 = () -> {
            System.out.println("I like lambda5");
        };
        like2.lambda();
    }
}

//函数式接口
interface ILike{
    void lambda();
}

class Like implements ILike{
    @Override
    public void lambda() {
        System.out.println("I like lambda1");
    }
}
