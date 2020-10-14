package com.example.groceriesmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected int timeout=3300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Animation img1= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.backitem1);
        Animation img2=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.backitem2);
        Animation img3= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.backitem3);
        Animation img4=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.backitem4);

        Animation logoanim=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.logoitem);


        ImageView i1=(ImageView)findViewById(R.id.img1);
        ImageView i2=(ImageView)findViewById(R.id.img2);
        ImageView i3=(ImageView)findViewById(R.id.img3);
        ImageView i4=(ImageView)findViewById(R.id.img4);

        ImageView logo=(ImageView)findViewById(R.id.icon);
        TextView logotext=(TextView)findViewById(R.id.logoname);

        i1.startAnimation(img1);
        i2.startAnimation(img2);
        i3.startAnimation(img3);
        i4.startAnimation(img4);


        logo.startAnimation(logoanim);
        logotext.startAnimation(logoanim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent2 = new Intent(MainActivity.this,activity2.class);
                startActivity(intent2);
                finish();
            }
        },timeout);
    }
}
