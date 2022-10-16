public class Thread01Test {
    public static void main(String[] args) throws InterruptedException {
        Thread01 t=new Thread01();
        System.out.println(Thread.currentThread().getName());
        t.start();//启动线程,会以启动线程的方式启动t.run()
        //main线程启动子程序，主线程不会阻塞，会继续执行
        for(int i=0;i<10;i++){
            System.out.println("主线程i="+i);
            Thread.sleep(1100);
        }
    }
}
