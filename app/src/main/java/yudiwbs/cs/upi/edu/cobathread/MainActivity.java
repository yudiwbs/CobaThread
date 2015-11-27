package yudiwbs.cs.upi.edu.cobathread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ProgressBar pb;
    TextView tvHasil;
    int progress=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb = (ProgressBar) findViewById(R.id.progressBar);
        tvHasil = (TextView) findViewById(R.id.tvHasil);
    }

    public void onClick(View v) {



        //menggunakan anonimousclass
        new Thread(new Runnable() {
            public void run() {

                //mulai, update ke UI
                tvHasil.post(new Runnable() {
                    public void run() {
                        tvHasil.setText("Mulai");
                    }
                });

                for (int i = 0; i<100;i++) {
                    try {
                        Thread.sleep(50);  //delay 0.05 detik
                        progress = i;
                        //update user interface harus menggunakan View.post(Runnable)
                        pb.post(new Runnable() {
                            public void run() {
                                pb.setProgress(progress);
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //sudah selesai, kirim lagi update
                tvHasil.post(new Runnable() {
                    public void run() {
                        tvHasil.setText("Sukses");
                    }
                });

            }
        }).start();
    }


}
