public class MyThread implements Runnable {
    String mess;

    public MyThread(String mess) {
        this.mess = mess;
    }

    @Override
    public void run() {
        if (mess.equals("pong")){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(mess);
        }
    }
}