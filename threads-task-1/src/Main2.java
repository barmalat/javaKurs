public class Main2 {
    public static void main(String[] args) {
        Thread ping = new Thread(new MyThread2("Ping"));
        Thread pong = new Thread(new MyThread2("Pong"));

        ping.start();
        pong.start();
    }
}