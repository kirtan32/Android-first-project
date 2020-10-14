package com.example.groceriesmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class milkact extends AppCompatActivity
{
    CheckBox chk1,chk2,chk3,chk4,chk5,chk6,chk7,chk8,chk9,chk10;
    Button addtocart;
    Spinner sp;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_milkact);

        chk1=(CheckBox)findViewById(R.id.lay1checkmilk);
        chk2=(CheckBox)findViewById(R.id.lay2checkmilk);
        chk3=(CheckBox)findViewById(R.id.lay3checkmilk);
        chk4=(CheckBox)findViewById(R.id.lay4checkmilk);
        chk5=(CheckBox)findViewById(R.id.lay5checkmilk);
        chk6=(CheckBox)findViewById(R.id.lay6checkmilk);
        chk7=(CheckBox)findViewById(R.id.lay7checkmilk);
        chk8=(CheckBox)findViewById(R.id.lay8checkmilk);
        chk9=(CheckBox)findViewById(R.id.lay9checkmilk);

        dbHelper = new DBHelper(this);

        addtocart=(Button)findViewById(R.id.addtocartmilk);
        addtocart.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        if(chk1.isChecked())
                        {
                            TextView t1=(TextView)findViewById(R.id.lay1pricemilk);
                            TextView t2=(TextView)findViewById(R.id.lay1textmilk);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.milk1;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay1spinmilkl);
                            String c=String.valueOf(sp.getSelectedItem());

                            if(dbHelper.insertData(imageid,imgname,price,c))
                            {
                                Toast.makeText(getApplicationContext(), imgname+" Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(), imgname+" Can't buy", Toast.LENGTH_SHORT).show();
                            }
                        }
                        if(chk2.isChecked())
                        {
                            TextView t1=(TextView)findViewById(R.id.lay2pricemilk);
                            TextView t2=(TextView)findViewById(R.id.lay2textmilk);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.milk2;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay2spinmilkl);
                            String c=String.valueOf(sp.getSelectedItem());

                            if(dbHelper.insertData(imageid,imgname,price,c))
                            {
                                Toast.makeText(getApplicationContext(), imgname+" Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(), imgname+" Can't buy", Toast.LENGTH_SHORT).show();
                            }
                        }
                        if(chk3.isChecked())
                        {
                            TextView t1=(TextView)findViewById(R.id.lay3pricemilk);
                            TextView t2=(TextView)findViewById(R.id.lay3textmilk);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.milk3;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay3spinmilkl);
                            String c=String.valueOf(sp.getSelectedItem());

                            if(dbHelper.insertData(imageid,imgname,price,c))
                            {
                                Toast.makeText(getApplicationContext(), imgname+" Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(), imgname+" Can't buy", Toast.LENGTH_SHORT).show();
                            }
                        }
                        if(chk4.isChecked())
                        {
                            TextView t1=(TextView)findViewById(R.id.lay4pricemilk);
                            TextView t2=(TextView)findViewById(R.id.lay4textmilk);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.milk4;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay4spinmilkl);
                            String c=String.valueOf(sp.getSelectedItem());

                            if(dbHelper.insertData(imageid,imgname,price,c))
                            {
                                Toast.makeText(getApplicationContext(), imgname+" Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(), imgname+" Can't buy", Toast.LENGTH_SHORT).show();
                            }
                        }
                        if(chk5.isChecked())
                        {
                            TextView t1=(TextView)findViewById(R.id.lay5pricemilk);
                            TextView t2=(TextView)findViewById(R.id.lay5textmilk);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.milk5;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay5spinmilkl);
                            String c=String.valueOf(sp.getSelectedItem());

                            if(dbHelper.insertData(imageid,imgname,price,c))
                            {
                                Toast.makeText(getApplicationContext(), imgname+" Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(), imgname+" Can't buy", Toast.LENGTH_SHORT).show();
                            }
                        }
                        if(chk6.isChecked())
                        {
                            TextView t1=(TextView)findViewById(R.id.lay6pricemilk);
                            TextView t2=(TextView)findViewById(R.id.lay6textmilk);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.milk6;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay6spinmilkl);
                            String c=String.valueOf(sp.getSelectedItem());

                            if(dbHelper.insertData(imageid,imgname,price,c))
                            {
                                Toast.makeText(getApplicationContext(), imgname+" Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(), imgname+" Can't buy", Toast.LENGTH_SHORT).show();
                            }
                        }
                        if(chk7.isChecked())
                        {
                            TextView t1=(TextView)findViewById(R.id.lay7pricemilk);
                            TextView t2=(TextView)findViewById(R.id.lay7textmilk);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.milk7;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay7spinmilkl);
                            String c=String.valueOf(sp.getSelectedItem());

                            if(dbHelper.insertData(imageid,imgname,price,c))
                            {
                                Toast.makeText(getApplicationContext(), imgname+" Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(), imgname+" Can't buy", Toast.LENGTH_SHORT).show();
                            }
                        }
                        if(chk8.isChecked())
                        {
                            TextView t1=(TextView)findViewById(R.id.lay8pricemilk);
                            TextView t2=(TextView)findViewById(R.id.lay8textmilk);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.milk8;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay8spinmilkl);
                            String c=String.valueOf(sp.getSelectedItem());

                            if(dbHelper.insertData(imageid,imgname,price,c))
                            {
                                Toast.makeText(getApplicationContext(), imgname+" Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(), imgname+" Can't buy", Toast.LENGTH_SHORT).show();
                            }
                        }
                        if(chk9.isChecked())
                        {
                            TextView t1=(TextView)findViewById(R.id.lay9pricemilk);
                            TextView t2=(TextView)findViewById(R.id.lay9textmilk);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.milk9;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay9spinmilkl);
                            String c=String.valueOf(sp.getSelectedItem());

                            if(dbHelper.insertData(imageid,imgname,price,c))
                            {
                                Toast.makeText(getApplicationContext(), imgname+" Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(), imgname+" Can't buy", Toast.LENGTH_SHORT).show();
                            }
                        }

                    }
                }
        );

    }
    public void GetBack(View view)
    {
        Intent intentbackmilk = new Intent(milkact.this,activity2.class);
        startActivity(intentbackmilk);
    }

    public void CheckCart(View view)
    {
        Intent intentcartmilk = new Intent(milkact.this,cartact.class);
        startActivity(intentcartmilk);
    }
}
