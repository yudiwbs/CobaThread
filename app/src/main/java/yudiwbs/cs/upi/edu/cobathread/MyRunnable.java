package yudiwbs.cs.upi.edu.cobathread;

/**
 * Created by masayu on 11/17/2015.
 */


public class MyRunnable implements Runnable {
    public void run() {
        //jalankan thread
    }

    public static void main(String args[]) {
        //versi panjang:
        MyRunnable r  = new MyRunnable();
        Thread t = new Thread(r); //runnnable jadi parameter
        t.start();

        //versi pendek dengan anonymous class
        //(new Thread(new MyRunnable())).start();


    }
}

