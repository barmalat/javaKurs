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
        try {
            if (mess.equals("Ping")) {
                for (int i = 0; i < 10; i++) {
                    ping();
                }
            }
            if (mess.equals("Pong")) {
                for (int i = 0; i < 10; i++) {
                    pong();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    private void ping() throws InterruptedException {
        lock.lock();
        while (!pingTurn) {
            notPing.await();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(mess);
        pingTurn = false;
        notPong.signal();
        lock.unlock();
    }

    private void pong() throws InterruptedException {
        lock.lock();
        while (pingTurn) {
            notPong.await();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(mess);
        pingTurn = true;
        notPing.signal();
        lock.unlock();
    }
}