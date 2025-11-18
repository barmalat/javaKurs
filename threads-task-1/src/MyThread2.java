import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread2 implements Runnable {
    private String mess;
    private static boolean pingTurn = true;

    public MyThread2(String mess) {
        this.mess = mess;
    }

    private final static Lock lock = new ReentrantLock();
    private final static Condition notPing = lock.newCondition();
    private final static Condition notPong = lock.newCondition();

    @Override
    public void run() {
        lock.lock();
        try {
            if (mess.equals("Ping")) {
                while (!pingTurn) {
                    notPing.await();
                }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(mess);
                pingTurn = false;
                notPong.signal();
            }
            if (mess.equals("Pong")) {
                while (pingTurn) {
                    notPong.await();
                }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(mess);
                pingTurn = true;
                notPing.signal();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}