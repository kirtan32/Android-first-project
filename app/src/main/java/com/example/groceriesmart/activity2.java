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
    /*
    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity2.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(activity2.this, "Write External Storage permission allows us to save files. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(activity2.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
        }
    }

    public  boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                System.out.println("Permission is granted");
                return true;
            } else {

                System.out.println("Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            System.out.println("Permission is granted in < 23 version");
            return true;
        }
    }
*/


//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        switch (requestCode) {
//            case 2:
//                //Log.d(TAG, "External storage2");
//                if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
//                    //Log.v(TAG,"Permission: "+permissions[0]+ "was "+grantResults[0]);
//                    //resume tasks needing this permission
//                }else{
//                    //progress.dismiss();
//                }
//                break;
//
//            case 3:
//                //Log.d(TAG, "External storage1");
//                if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
//                  //  Log.v(TAG,"Permission: "+permissions[0]+ "was "+grantResults[0]);
//                    //resume tasks needing this permission
//                }else{
//                   // progress.dismiss();
//                }
//                break;
//        }
//    }

    public void CheckCart(View view)
    {
        Intent intentcartcart1 = new Intent(activity2.this,cartact.class);
        startActivity(intentcartcart1);
    }
}
