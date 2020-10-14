package com.example.groceriesmart;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.icu.text.DateFormat;
import android.icu.text.DecimalFormat;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

public class generatepdf extends AppCompatActivity
{
    private static final int PERMISSION_REQUEST_CODE = 100;

    String name,email,contact,address,city,state;
    String total,finalcurrentid;
    TextView invoiceid,paymentdue,totalamount,tax,shipping,payable;
    DBHelper dbHelper;

    Bitmap bmp,scaledbmp,bmp2,scaledbmp2;
    int pageWidth=1200;
    Date dataobj;
    DateFormat dateformat;

    @RequiresApi(api = Build.VERSION_CODES.N)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_generatepdf);

        dbHelper=new DBHelper(this);

        Intent intent=getIntent();
        name=intent.getStringExtra("name");
        email=intent.getStringExtra("email");
        contact=intent.getStringExtra("contact");
        address=intent.getStringExtra("address");
        city=intent.getStringExtra("city");
        state=intent.getStringExtra("state");

        total=intent.getStringExtra("total");
        float num=Float.parseFloat(total);

        float per= (float) (num*(0.12));
        //per=new DecimalFormat("##.##").format(per);
        per=(float) Math.round(per * 100) / 100;

        float ship= (float) (num*(0.02));
        ship=(float) Math.round(ship * 100) / 100;

        float pay=num+per+ship;
        pay=(float)Math.round(pay*100)/100;
        Date c = Calendar.getInstance().getTime();
        String currentdate=""+c;
        currentdate= currentdate.substring(0,18);
        finalcurrentid="";
        for(int i=0;i<currentdate.length();i++)
        {
            if(currentdate.charAt(i)==' ' ||  currentdate.charAt(i)==':') {
            }
            else
            {
                finalcurrentid+=currentdate.charAt(i);
            }

        }
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("ddMMMyyyy");
        String formattedDate = df.format(c);

        String idinvoicestr="IN"+finalcurrentid.toLowerCase()+formattedDate;

        invoiceid=(TextView)findViewById(R.id.invoiceid);
        invoiceid.setText(idinvoicestr);

        paymentdue=(TextView)findViewById(R.id.paymentdue);
        paymentdue.setText(formattedDate);

        totalamount=(TextView)findViewById(R.id.totalamount);
        totalamount.setText("$"+num);

        tax=(TextView)findViewById(R.id.tax);
        tax.setText("$"+per);

        shipping=(TextView)findViewById(R.id.shippingtax);
        shipping.setText("$"+ship);

        payable=(TextView)findViewById(R.id.payableamount);
        payable.setText("$"+pay);

        initBitmap();

        Toast.makeText(getApplicationContext(), "Invoice is Ready to Download", Toast.LENGTH_LONG).show();

    }

    public void initBitmap()
    {
        bmp= BitmapFactory.decodeResource(getResources(),R.drawable.pdfback5);
        bmp2=BitmapFactory.decodeResource(getResources(),R.drawable.grocery2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,1200,550,false);
        scaledbmp2 = Bitmap.createScaledBitmap(bmp2,100,100,false);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void createfilehere()
    {
        PdfDocument mypdf = new PdfDocument();
        Paint mypaint=new Paint();

        int no=dbHelper.numberOfRows();
        String[][] st=dbHelper.getDataProducts();

        PdfDocument.PageInfo mypageinfo=new PdfDocument.PageInfo.Builder(1200,2400,1).create();

        PdfDocument.Page mypage=mypdf.startPage(mypageinfo);

        Canvas canvas = mypage.getCanvas();

        canvas.drawBitmap(scaledbmp,0,0,mypaint);
        canvas.drawBitmap(scaledbmp2,50,500,mypaint);

        Paint titlepaint=new Paint();
        Paint samplepaint=new Paint();

        titlepaint.setTextAlign(Paint.Align.CENTER);
        titlepaint.setTypeface(Typeface.create(Typeface.DEFAULT,Typeface.BOLD));
        titlepaint.setColor(Color.rgb(255,69,0));
        titlepaint.setTextSize(70);

        canvas.drawText("GMart",  250,580,titlepaint);

        samplepaint.setColor(getResources().getColor(R.color.black_overlay));
        samplepaint.setTypeface(Typeface.create(Typeface.DEFAULT,Typeface.BOLD));
        samplepaint.setTextAlign(Paint.Align.RIGHT);
        samplepaint.setTextSize(20f);
        canvas.drawText("Query",pageWidth-20,540,samplepaint);
        samplepaint.setTypeface(Typeface.create(Typeface.DEFAULT,Typeface.NORMAL));
        canvas.drawText("+91 8238054019",pageWidth-20,565,samplepaint);
        canvas.drawText("shahkirtan742@gmail.com",pageWidth-20,590,samplepaint);

        mypaint.setColor(getResources().getColor(R.color.Orangelite));
        canvas.drawRect(0,600,1200,940,mypaint);

        titlepaint.setColor(getResources().getColor(R.color.colorPrimary));
        titlepaint.setTextSize(40);
        titlepaint.setTextAlign(Paint.Align.LEFT);

        canvas.drawText("INVOICE",50,670,titlepaint);

        titlepaint.setTypeface(Typeface.create(Typeface.DEFAULT,Typeface.NORMAL));
        titlepaint.setColor(getResources().getColor(R.color.black_overlay));
        titlepaint.setTextSize(25f);
        titlepaint.setTextAlign(Paint.Align.LEFT);

        try{
            canvas.drawText("InvoiceID: ",50,720,titlepaint);
            canvas.drawText(invoiceid.getText().toString(),310,720,titlepaint);

            canvas.drawText("Customer Name: ",50,750,titlepaint);
            canvas.drawText(name.toString(),310,750,titlepaint);

            canvas.drawText("Contact Number:   +91 ",50,780,titlepaint);
            canvas.drawText(contact.toString(),310,780,titlepaint);

            canvas.drawText("Email: ",50,810,titlepaint);
            canvas.drawText(email.toString(),310,810,titlepaint);

            canvas.drawText("Shipping Address: ",50,840,titlepaint);
            canvas.drawText(address.toString(),310,840,titlepaint);

            canvas.drawText("City: ",50,870,titlepaint);
            canvas.drawText(city.toString(),310,870,titlepaint);

            canvas.drawText("State: ",50,900,titlepaint);
            canvas.drawText(state.toString(),310,900,titlepaint);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Error in invoice writing", Toast.LENGTH_LONG).show();
        }

        titlepaint.setTypeface(Typeface.create(Typeface.DEFAULT,Typeface.BOLD));
        titlepaint.setColor(getResources().getColor(R.color.colorAccent2));
        titlepaint.setTextSize(30);
        titlepaint.setTextAlign(Paint.Align.LEFT);

        mypaint.setColor(getResources().getColor(R.color.bluelight2));
        mypaint.setStrokeWidth(0);
        canvas.drawRect(50,1020,1150,1120+(no*60)+280,mypaint);

        canvas.drawText("Description",50,1000,titlepaint);

        mypaint.setColor(getResources().getColor(R.color.bluelight));
        mypaint.setStrokeWidth(0);
        canvas.drawRect(50,1020,1150,1080,mypaint);


        titlepaint.setTypeface(Typeface.create(Typeface.DEFAULT,Typeface.BOLD));
        titlepaint.setColor(getResources().getColor(R.color.black_overlay));
        titlepaint.setTextSize(25f);
        titlepaint.setTextAlign(Paint.Align.LEFT);

        canvas.drawText("Sr.No",70,1060,titlepaint);
        canvas.drawText("Item Description",200,1060,titlepaint);
        canvas.drawText("Price",800,1060,titlepaint);
        canvas.drawText("Qty",950,1060,titlepaint);
        canvas.drawText("Total",1050,1060,titlepaint);

        canvas.drawLine(170,1030,170,1070,titlepaint);
        canvas.drawLine(770,1030,770,1070,titlepaint);
        canvas.drawLine(920,1030,920,1070,titlepaint);
        canvas.drawLine(1020,1030,1020,1070,titlepaint);

        titlepaint.setTypeface(Typeface.create(Typeface.DEFAULT,Typeface.NORMAL));
        titlepaint.setColor(getResources().getColor(R.color.black_overlay));
        titlepaint.setTextSize(24f);
        titlepaint.setTextAlign(Paint.Align.LEFT);

        int i=0;
        for(i=1;i<=no;i++)
        {
            canvas.drawText(""+i,70,1120+((i-1)*60),titlepaint);
            canvas.drawText(""+st[i-1][1],200,1120+((i-1)*60),titlepaint);
            canvas.drawText("$"+st[i-1][2],800,1120+((i-1)*60),titlepaint);
            canvas.drawText(""+st[i-1][3],950,1120+((i-1)*60),titlepaint);
            float num1=Float.parseFloat(st[i-1][2]);
            float num2=num1*Integer.parseInt(st[i-1][3]);
            String str1;
            str1 = ""+String.format("%.02f", num2);
            canvas.drawText("$"+str1,1050,1120+((i-1)*60),titlepaint);

//            if(i!=no)
//            {
//                canvas.drawLine(60,1090+(i*60),1140,1090+(i*60),titlepaint);
//            }

        }

        int lastdraw=1120+(no*60);
        titlepaint.setColor(getResources().getColor(R.color.bluelight));
        canvas.drawLine(750,lastdraw,1150,lastdraw,titlepaint);

        titlepaint.setColor(getResources().getColor(R.color.black_overlay));
        titlepaint.setTextAlign(Paint.Align.LEFT);

        canvas.drawText("Sub Total:",800,lastdraw+40,titlepaint);
        canvas.drawText("Tax (12%):",800,lastdraw+90,titlepaint);
        canvas.drawText("Shipping & Handling:",800,lastdraw+140,titlepaint);
        titlepaint.setColor(getResources().getColor(R.color.yello));
        canvas.drawRect(750,lastdraw+180,1150,lastdraw+230,titlepaint);
        titlepaint.setColor(getResources().getColor(R.color.black_overlay));
        titlepaint.setTypeface(Typeface.create(Typeface.DEFAULT,Typeface.BOLD));
        canvas.drawText("Payable Amount: ",800,lastdraw+210,titlepaint);

        titlepaint.setTypeface(Typeface.create(Typeface.DEFAULT,Typeface.NORMAL));
        titlepaint.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText(""+totalamount.getText().toString(),pageWidth-80,lastdraw+40,titlepaint);
        canvas.drawText(""+tax.getText().toString(),pageWidth-80,lastdraw+90,titlepaint);
        canvas.drawText(""+shipping.getText().toString(),pageWidth-80,lastdraw+145,titlepaint);
        titlepaint.setTypeface(Typeface.create(Typeface.DEFAULT,Typeface.BOLD));
        canvas.drawText(""+payable.getText().toString(),pageWidth-80,lastdraw+210,titlepaint);

//        canvas.drawText("1",70,1120,titlepaint);
//        canvas.drawText("Apple Juise",200,1120,titlepaint);
//        canvas.drawText("$5.9",800,1120,titlepaint);
//        canvas.drawText("2",950,1120,titlepaint);
//        canvas.drawText("@11.8",1050,1120,titlepaint);

        mypdf.finishPage(mypage);

        try
        {
            File file=new File(Environment.getExternalStorageDirectory(),"/invoice"+finalcurrentid+".pdf");

            mypdf.writeTo(new FileOutputStream(file));
            System.out.println("File Written Successfully");
            Toast.makeText(getApplicationContext(), "Your Invoice is downloaded \n as invoice"+finalcurrentid+".pdf", Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            System.out.println("Error in File writing");
            e.printStackTrace();
            System.out.println("# --> "+e.getMessage());

            Toast.makeText(getApplicationContext(), "Error In File Writing", Toast.LENGTH_LONG).show();
        }
        mypdf.close();


    }

    public void GetBack(View view)
    {
        Intent intentbackpdf = new Intent(generatepdf.this,cartact.class);
        startActivity(intentbackpdf);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void downloadpdf(View view)
    {
        createfilehere();
    }
}
