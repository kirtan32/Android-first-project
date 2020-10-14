package com.example.groceriesmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class act2 extends AppCompatActivity {

    CheckBox chk1,chk2,chk3,chk4,chk5,chk6,chk7,chk8,chk9,chk10;
    Button addtocart;
    int no_of_product;
    Spinner sp;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_act2);

        chk1=(CheckBox)findViewById(R.id.lay1check);
        chk2=(CheckBox)findViewById(R.id.lay2check);
        chk3=(CheckBox)findViewById(R.id.lay3check);
        chk4=(CheckBox)findViewById(R.id.lay4check);
        chk5=(CheckBox)findViewById(R.id.lay5check);
        chk6=(CheckBox)findViewById(R.id.lay6check);
        chk7=(CheckBox)findViewById(R.id.lay7check);
        chk8=(CheckBox)findViewById(R.id.lay8check);
        chk9=(CheckBox)findViewById(R.id.lay9check);
        chk10=(CheckBox)findViewById(R.id.lay10check);

        dbHelper = new DBHelper(this);

        addtocart=(Button)findViewById(R.id.addtocartfruit);
        addtocart.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        int count=0;
                        if(chk1.isChecked())
                        {
                            TextView t1=(TextView)findViewById(R.id.lay1price);
                            TextView t2=(TextView)findViewById(R.id.lay1text);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.apple;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay1spin);
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
                            TextView t1=(TextView)findViewById(R.id.lay2price);
                            TextView t2=(TextView)findViewById(R.id.lay2text);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.fruit1;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay2spin);
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
                            TextView t1=(TextView)findViewById(R.id.lay3price);
                            TextView t2=(TextView)findViewById(R.id.lay3text);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.fruit2;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay3spin);
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
                            TextView t1=(TextView)findViewById(R.id.lay4price);
                            TextView t2=(TextView)findViewById(R.id.lay4text);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.fruit3;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay4spin);
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
                            TextView t1=(TextView)findViewById(R.id.lay5price);
                            TextView t2=(TextView)findViewById(R.id.lay5text);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.fruit4;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay5spin);
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
                            TextView t1=(TextView)findViewById(R.id.lay6price);
                            TextView t2=(TextView)findViewById(R.id.lay6text);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.fruit5;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay6spin);
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
                            TextView t1=(TextView)findViewById(R.id.lay7price);
                            TextView t2=(TextView)findViewById(R.id.lay7text);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.fruit6;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay7spin);
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
                            TextView t1=(TextView)findViewById(R.id.lay8price);
                            TextView t2=(TextView)findViewById(R.id.lay8text);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.fruit7;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay8spin);
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
                            TextView t1=(TextView)findViewById(R.id.lay9price);
                            TextView t2=(TextView)findViewById(R.id.lay9text);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.fruit8;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay9spin);
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
                            TextView t1=(TextView)findViewById(R.id.lay10price);
                            TextView t2=(TextView)findViewById(R.id.lay10text);
                            String imgname=t2.getText().toString();
                            String imageid=""+R.drawable.fruit9;
                            String price= t1.getText().toString().substring(1);
                            sp=(Spinner)findViewById(R.id.lay10spin);
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
        Intent intentbackfruit = new Intent(act2.this,activity2.class);
        startActivity(intentbackfruit);
    }

    public void CheckCart(View view)
    {
        Intent intentcartfruit = new Intent(act2.this,cartact.class);
        startActivity(intentcartfruit);
    }
}
