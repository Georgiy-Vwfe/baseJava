package ru;

public class MainDeadlock {
    private static final Object LOCK_1 = new Object();
    private static final Object LOCK_2 = new Object();

    public static void main(String[] args) {
        ThreadTest thread1 = new ThreadTest(1, 2, LOCK_1, LOCK_2);
        ThreadTest thread2 = new ThreadTest(2, 1, LOCK_2, LOCK_1);
        thread1.start();
        thread2.start();
    }

    private static class ThreadTest extends Thread {
        int threadNum1;
        int threadNum2;
        Object lock1;
        Object lock2;

        public ThreadTest(int threadNum1, int threadNum2, Object lock1, Object lock2) {
            this.threadNum1 = threadNum1;
            this.threadNum2 = threadNum2;
            this.lock1 = lock1;
            this.lock2 = lock2;
        }

        public void run() {
            threadHold(threadNum1, threadNum2, lock1, lock2);
        }

        public void threadHold(int threadNum1, int threadNum2, Object lock1, Object lock2) {
            synchronized (lock1) {
                System.out.println("Thread " + threadNum1 + ": Holding lock " + threadNum1 + "...");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException ignored) {
                }
                System.out.println("Thread " + threadNum1 + ": Waiting lock " + threadNum2 + "...");

                synchronized (lock2) {
                    System.out.println("Thread " + threadNum1 + ": Holding lock 1 & 2...");
                }
            }
        }
    }

}
