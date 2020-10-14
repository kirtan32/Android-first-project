package com.example.groceriesmart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class activity2 extends AppCompatActivity
{

    Button fruit,veg,snack,milk;
    ImageView imgfruit,imgveg,imgsnack,imgmilk;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_activity2);

        isReadStoragePermissionGranted();
        isWriteStoragePermissionGranted();

        //ActivityCompat.requestPermissions(activity2.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

        Animation leftright= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.leftright);
        Animation rightleft=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rightleft);

        fruit=(Button)findViewById(R.id.buttonfruit);
        veg=(Button)findViewById(R.id.buttonveg);
        milk=(Button)findViewById(R.id.buttondairy);
        snack=(Button)findViewById(R.id.buttonsnack);

        imgfruit=(ImageView)findViewById(R.id.imgfruit);
        imgveg=(ImageView)findViewById(R.id.imgveg);
        imgmilk=(ImageView)findViewById(R.id.imgdairy);
        imgsnack=(ImageView)findViewById(R.id.imgsnack);

        fruit.startAnimation(leftright);
        imgfruit.startAnimation(leftright);

        milk.startAnimation(leftright);
        imgmilk.startAnimation(leftright);

        veg.startAnimation(rightleft);
        imgveg.startAnimation(rightleft);

        snack.startAnimation(rightleft);
        imgsnack.startAnimation(rightleft);

        fruit.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent intentf = new Intent(activity2.this,act2.class);
                        startActivity(intentf);
                    }
                }
        );
        veg.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent intentv = new Intent(activity2.this,vegitableact.class);
                        startActivity(intentv);
                    }
                }
        );
        snack.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent intentv = new Intent(activity2.this,snacksact.class);
                        startActivity(intentv);
                    }
                }
        );
        milk.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent intentv = new Intent(activity2.this,milkact.class);
                        startActivity(intentv);
                    }
                }
        );
    }

    public  boolean isReadStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                System.out.println("Permission is granted");
                return true;
            } else {
                System.out.println("Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 3);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            System.out.println("Permission is granted in < 23 version");
            return true;
        }
    }

    public  boolean isWriteStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                System.out.println("Permission is granted");
                return true;
            } else {
                System.out.println("Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            System.out.println("Permission is granted in < 23 version");
            return true;
        }
    }


    public void CheckCart(View view)
    {
        Intent intentcartcart1 = new Intent(activity2.this,cartact.class);
        startActivity(intentcartcart1);
    }
}
