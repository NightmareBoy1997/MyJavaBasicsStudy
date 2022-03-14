package comguigu.java1;

/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 *
 * @author shkstart
 * @create 2021-03-16 11:47
 */
class BankUp{
    private static BankUp instance;

    private BankUp(){
    }

    public  static BankUp getBank(){
        //方式一：效率稍差
//        synchronized (Bank.class) {
//            if(instance ==null){
//                instance =new Bank();
//            }
//            return instance;
//        }

        //方式二：效率更高
        if(instance==null) {
            synchronized (BankUp.class) {
                instance = new BankUp();
            }
        }
            return instance;
    }
}