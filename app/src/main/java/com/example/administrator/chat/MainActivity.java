package com.example.administrator.chat;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
    private splashhandler Handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        android.os.Handler x = new Handler();
        x.postDelayed(new splashhandler(), 2000);

    }
    class splashhandler implements Runnable{
        public void run() {
            startActivity(new Intent(getApplication(),Main2Activity.class));
            MainActivity.this.finish();
        }
    };
}
