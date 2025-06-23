package create_thread;

/*
静态代理模式
真实对象和代理对象实现同一个抽象对象接口
代理对象要代理真实对象
好处：
代理对象扩充真实对象的方法（在真实对象的方法前后扩充通用逻辑，将该通用逻辑抽象出来放到代理对象中）
 */
public class StaticProxy {
    public static void main(String[] args) {
        //静态代理
        new Thread( () -> System.out.println("I love you!")).start();
        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.HappyMarry();
    }
}

//抽象对象
interface Marry {
    void HappyMarry();
}

class You implements Marry {
    @Override
    public void HappyMarry() {
        System.out.println("I'm Marrying");
    }
}

class WeddingCompany implements Marry{
    //代理
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }
    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    public void before() {
        System.out.println("Decorate Wedding Scene");
    }

    public void after() {
        System.out.println("Final Payment");
    }
}
