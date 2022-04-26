package homework4;

public class Main {
    private final Object pr = new Object();
    private volatile char curLet = 'A';

    public static void main(String[] args) {
        Main m = new Main();
        Thread t1 = new Thread(m::printA);
        Thread t2 = new Thread(m::printB);
        Thread t3 = new Thread(m::printC);

        t1.start();
        t2.start();
        t3.start();
    }

    public void printA() {
        synchronized (pr) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (curLet != 'A') {
                        pr.wait();
                    }
                    System.out.print('A');
                    curLet = 'B';
                    pr.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (pr) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (curLet != 'B') {
                        pr.wait();
                    }
                    System.out.print('B');
                    curLet = 'C';
                    pr.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printC() {
        synchronized (pr) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (curLet != 'C') {
                        pr.wait();
                    }
                    System.out.print('C');
                    curLet = 'A';
                    pr.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

