public class Thread01 extends Thread {
    public void run (){
        int time=0;
        while (time!=10) {
            try {
                System.out.println("hello word"+(++time)+Thread.currentThread().toString());
                sleep(1000);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
