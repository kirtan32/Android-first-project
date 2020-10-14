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

public class snacksact extends AppCompatActivity
{
    CheckBox chk1,chk2,chk3,chk4,chk5,chk6,chk7,chk8;
    Button addtocart;
    Spinner sp;

    DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_snacksact);

        chk1=(CheckBox)findViewById(R.id.lay1checksnacks);
        chk2=(CheckBox)findViewById(R.id.lay2checksnacks);
        chk3=(CheckBox)findViewById(R.id.lay3checksnacks);
        chk4=(CheckBox)findViewById(R.id.lay4checksnacks);
        chk5=(CheckBox)findViewById(R.id.lay5checksnacks);
        chk6=(CheckBox)findViewById(R.id.lay6checksnacks);
        chk7=(CheckBox)findViewById(R.id.lay7checksnacks);
        chk8=(CheckBox)findViewById(R.id.lay8checksnacks);

        dbHelper = new DBHelper(this);

        addtocart=(Button)findViewById(R.id.addtocartsnacks);
        addtocart.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        if(chk1.isChecked())
                        {
                            TextView t1=(TextView)findViewById(R.id.lay1pricesnacks);
                            TextView t2=(TextView)findViewById(R.id.lay1textsnacks);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.snacks1;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay1spinsnacks);
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
                            TextView t1=(TextView)findViewById(R.id.lay2pricesnacks);
                            TextView t2=(TextView)findViewById(R.id.lay2textsnacks);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.snacks2;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay2spinsnacks);
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
                            TextView t1=(TextView)findViewById(R.id.lay3pricesnacks);
                            TextView t2=(TextView)findViewById(R.id.lay3textsnacks);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.snacks3;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay3spinsnacks);
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
                            TextView t1=(TextView)findViewById(R.id.lay4pricesnacks);
                            TextView t2=(TextView)findViewById(R.id.lay4textsnacks);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.snacks4;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay4spinsnacks);
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
                            TextView t1=(TextView)findViewById(R.id.lay5pricesnacks);
                            TextView t2=(TextView)findViewById(R.id.lay5textsnacks);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.snacks5;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay5spinsnacks);
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
                            TextView t1=(TextView)findViewById(R.id.lay6pricesnacks);
                            TextView t2=(TextView)findViewById(R.id.lay6textsnacks);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.snacks6;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay6spinsnacks);
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
                            TextView t1=(TextView)findViewById(R.id.lay7pricesnacks);
                            TextView t2=(TextView)findViewById(R.id.lay7textsnacks);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.snacks7;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay7spinsnacks);
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
                            TextView t1=(TextView)findViewById(R.id.lay8pricesnacks);
                            TextView t2=(TextView)findViewById(R.id.lay8textsnacks);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.snacks8;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay8spinsnacks);
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
        Intent intentbacksnack = new Intent(snacksact.this,activity2.class);
        startActivity(intentbacksnack);
    }

    public void CheckCart(View view)
    {
        Intent intentcartsnack = new Intent(snacksact.this,cartact.class);
        startActivity(intentcartsnack);
    }
}
