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

public class vegitableact extends AppCompatActivity
{
    CheckBox chk1,chk2,chk3,chk4,chk5,chk6,chk7,chk8,chk9,chk10,chk11,chk12;
    Button addtocart;
    Spinner sp;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_vegitableact);

        chk1=(CheckBox)findViewById(R.id.lay1checkveg);
        chk2=(CheckBox)findViewById(R.id.lay2checkveg);
        chk3=(CheckBox)findViewById(R.id.lay3checkveg);
        chk4=(CheckBox)findViewById(R.id.lay4checkveg);
        chk5=(CheckBox)findViewById(R.id.lay5checkveg);
        chk6=(CheckBox)findViewById(R.id.lay6checkveg);
        chk7=(CheckBox)findViewById(R.id.lay7checkveg);
        chk8=(CheckBox)findViewById(R.id.lay8checkveg);
        chk9=(CheckBox)findViewById(R.id.lay9checkveg);
        chk10=(CheckBox)findViewById(R.id.lay10checkveg);
        chk11=(CheckBox)findViewById(R.id.lay11checkveg);
        chk12=(CheckBox)findViewById(R.id.lay12checkveg);

        dbHelper = new DBHelper(this);

        addtocart=(Button)findViewById(R.id.addtocartveg);
        addtocart.setOnClickListener(
                new Button.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        if(chk1.isChecked())
                        {
                            TextView t1=(TextView)findViewById(R.id.lay1priceveg);
                            TextView t2=(TextView)findViewById(R.id.lay1textveg);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.vegitable1;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay1spinveg);
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
                            TextView t1=(TextView)findViewById(R.id.lay2priceveg);
                            TextView t2=(TextView)findViewById(R.id.lay2textveg);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.vegitable2;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay2spinveg);
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
                            TextView t1=(TextView)findViewById(R.id.lay3priceveg);
                            TextView t2=(TextView)findViewById(R.id.lay3textveg);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.vegitable3;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay3spinveg);
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
                            TextView t1=(TextView)findViewById(R.id.lay4priceveg);
                            TextView t2=(TextView)findViewById(R.id.lay4textveg);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.vegitable4;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay4spinveg);
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
                            TextView t1=(TextView)findViewById(R.id.lay5priceveg);
                            TextView t2=(TextView)findViewById(R.id.lay5textveg);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.vegitable5;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay5spinveg);
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
                            TextView t1=(TextView)findViewById(R.id.lay6priceveg);
                            TextView t2=(TextView)findViewById(R.id.lay6textveg);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.vegitable6;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay6spinveg);
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
                            TextView t1=(TextView)findViewById(R.id.lay7priceveg);
                            TextView t2=(TextView)findViewById(R.id.lay7textveg);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.vegitable7;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay7spinveg);
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
                            TextView t1=(TextView)findViewById(R.id.lay8priceveg);
                            TextView t2=(TextView)findViewById(R.id.lay8textveg);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.vegitable8;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay8spinveg);
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
                            TextView t1=(TextView)findViewById(R.id.lay9priceveg);
                            TextView t2=(TextView)findViewById(R.id.lay9textveg);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.vegitable9;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay9spinveg);
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
                        if(chk10.isChecked())
                        {
                            TextView t1=(TextView)findViewById(R.id.lay10priceveg);
                            TextView t2=(TextView)findViewById(R.id.lay10textveg);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.vegitable10;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay10spinveg);
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
                        if(chk11.isChecked())
                        {
                            TextView t1=(TextView)findViewById(R.id.lay11priceveg);
                            TextView t2=(TextView)findViewById(R.id.lay11textveg);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.vegitable11;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay11spinveg);
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
                        if(chk12.isChecked())
                        {
                            TextView t1=(TextView)findViewById(R.id.lay12priceveg);
                            TextView t2=(TextView)findViewById(R.id.lay12textveg);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.vegitable12;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay12spinveg);
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
        Intent intentbackveg = new Intent(vegitableact.this,activity2.class);
        startActivity(intentbackveg);
    }

    public void CheckCart(View view)
    {
        Intent intentcartveg = new Intent(vegitableact.this,cartact.class);
        startActivity(intentcartveg);
    }
}
