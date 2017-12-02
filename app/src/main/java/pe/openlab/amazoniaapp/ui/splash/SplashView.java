package pe.openlab.amazoniaapp.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import pe.openlab.amazoniaapp.R;
import pe.openlab.amazoniaapp.ui.login.LoginView;

public class SplashView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Thread(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashView.this, LoginView.class);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(intent);
                    finish();
                }
            }
        }).start();
    }

}