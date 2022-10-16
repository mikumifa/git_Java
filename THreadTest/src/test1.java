public class test1 {
    public static void main(String[] args) {
        Thread thread01=new Thread(new test1Thread01());
        Thread thread02=new Thread(new test1Thread02());
        thread01.start();
        thread02.start();
    }
}
class test1Thread01 implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("hello world");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class  test1Thread02 implements  Runnable{
    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println("hi");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
