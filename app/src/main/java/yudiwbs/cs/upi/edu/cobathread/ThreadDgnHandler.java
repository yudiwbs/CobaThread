package yudiwbs.cs.upi.edu.cobathread;

import android.os.Handler;

/**
 * Created by yudiwbs on 12/12/2015.
 */
public class ThreadDgnHandler extends Thread {
    private final Handler mHandler; //handler dari UI

    public ThreadDgnHandler(Handler mHandler) {
        this.mHandler = mHandler;
    }

    public void run() {
        //mulai, update ke UI
        //1: konstanta 1 artinya pesan untuk update textivew. konstanta bebas
        //-1: paramter 1, tidak digunakan
        //-1: paramter 2, tidak digunakan
        //"Mulai": paramter 3, bisa objek apapun
        mHandler.obtainMessage(1, -1, -1, "Mulai").sendToTarget();

        //loop peroses background
        for (int i = 0; i<100;i++) {
            try {
                Thread.sleep(50);  //delay 0.05 detik
                //2: update progres barr
                //i: paramter 1, progressnya
                //paramter yang lain tidak digunakan
                mHandler.obtainMessage(2, i, -1,null).sendToTarget();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //kirim pesan selesai
        mHandler.obtainMessage(1, -1, -1, "Selesai").sendToTarget();

    }




}
