public class Main2 {
    public static void main(String[] args) {
        Thread ping = new Thread(new MyThread2("Ping"));
        Thread ping2 = new Thread(new MyThread2("Ping"));
        Thread ping3 = new Thread(new MyThread2("Ping"));
        Thread pong = new Thread(new MyThread2("Pong"));
        Thread pong2 = new Thread(new MyThread2("Pong"));
        Thread pong3 = new Thread(new MyThread2("Pong"));

        ping.start();
        pong.start();
        ping2.start();
        pong2.start();
        ping3.start();
        pong3.start();

    }
}
