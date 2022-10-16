public class Thread02 {

    public static void main(String[] args) {
        Dog dog=new Dog();
        Thread thread=new Thread(dog);//静态代理，Dog实现了代理接口，而Thread有代理接口的成员，Thread会调用接口成员的方法，构造的时候如果传入的是Dog就会重写代理接口
        thread.start();
    }
}
class Dog implements Runnable{
    int count=0;

    @Override
    public void run() {
        int time=0;
        while (time!=10) {
            try {
                System.out.println("hello word"+(++time)+Thread.currentThread().getName());
                Thread.sleep(1000);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
