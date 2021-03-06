package design.singleton.singleton04;

/**
 * @Description: Singleton04单例模式-懒汉式（线程安全）
 * @Author: atong
 * @Date: 2020-06-15
 * @Version:v1.0
 */
public class Singleton04 {
    public static void main(String[] args) {
        //测试
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton == singleton1);
        System.out.println(singleton.hashCode());
        System.out.println(singleton1.hashCode());

    }
}
class Singleton {
    //私有构造函数，方式外部通过new创建对象
    private Singleton () {
    }

    //类的内部声明变量
    private static Singleton singleton;

    //对外暴露一个静态方法，当调用该方法时，才去创建实例（singleton）
    //添加synchronized修饰符，解决线程安全问题
    public static synchronized Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

}
