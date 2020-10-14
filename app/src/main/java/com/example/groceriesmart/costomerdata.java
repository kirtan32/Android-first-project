package com.example.groceriesmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class costomerdata extends AppCompatActivity
{
    EditText name,email,contact,address,city,state;
    String numstr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_costomerdata);

        name=(EditText)findViewById(R.id.cosname);
        email=(EditText)findViewById(R.id.cosemail);
        contact=(EditText)findViewById(R.id.coscontact);
        address=(EditText)findViewById(R.id.cosaddress);
        city=(EditText)findViewById(R.id.coscity);
        state=(EditText)findViewById(R.id.cosstate);

        Intent intent=getIntent();
        numstr=intent.getStringExtra("total");

    }

    public void GetBack(View view)
    {
        Intent intentback = new Intent(costomerdata.this,cartact.class);
        startActivity(intentback);
    }

    public void setnext(View view)
    {
        String strname,stremail,strcontact,straddress,strcity,strstate;
        strname=name.getText().toString();
        stremail=email.getText().toString();
        strcontact=contact.getText().toString();
        straddress=address.getText().toString();
        strcity=city.getText().toString();
        strstate=state.getText().toString();


        Intent intentnext = new Intent(costomerdata.this,generatepdf.class);
        intentnext.putExtra("name",strname);
        intentnext.putExtra("email",stremail);
        intentnext.putExtra("contact",strcontact);
        intentnext.putExtra("address",straddress);
        intentnext.putExtra("city",strcity);
        intentnext.putExtra("state",strstate);
        intentnext.putExtra("total",numstr);
        startActivity(intentnext);

    }
}
