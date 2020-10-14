package com.example.groceriesmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.groceriesmart.R.color;

public class cartact extends AppCompatActivity
{
    DBHelper dbHelper;
    Button proceed;
    ScrollView scroll;
    ImageView backcart;
    String numstr;

    int idofitemsdelete[];

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_cartact);

        dbHelper=new DBHelper(this);
        proceed = (Button)findViewById(R.id.proceed);
        scroll=(ScrollView)findViewById(R.id.scrollcart);
        backcart = (ImageView)findViewById(R.id.imagebackcart);
        displayitems();

    }
    public void displayitems()
    {
        float sum=0;
        int flag=0;
        String[][] st;
        int t=dbHelper.numberOfRows();
        if(t==0)
        {
            backcart.setVisibility(View.VISIBLE);
            scroll.setVisibility(View.INVISIBLE);
            proceed.setEnabled(false);
        }
        else
        {
            flag=1;
            st=dbHelper.getDataProducts();


            idofitemsdelete=new int[t];

            proceed.setEnabled(true);
            backcart.setVisibility(View.INVISIBLE);
            scroll.setVisibility(View.VISIBLE);

            for(int i=0;i<t;i++)
            {
                float bool1=printCompo(st[i][0],st[i][1],st[i][2],st[i][3],i);
                sum+=bool1;
                System.out.println(bool1);
            }
        }

         numstr=""+sum;
        System.out.println("---->>>>>>  "+sum);
        if(flag==0)
        {

        }
        else
        {
            try {

                numstr=numstr.substring(0,numstr.indexOf("."))+numstr.substring(numstr.indexOf("."),numstr.indexOf(".")+3);
            }
            catch (Exception e)
            {
                System.out.println("###---> String Index Out of bound");
            }

        }
        TextView tt1=(TextView)findViewById(R.id.totalid);
        tt1.setText("$"+numstr);
    }
    public float printCompo(final String imagename, final String productname, String price, String counts, int i)
    {
        GridLayout gridLayout = (GridLayout)findViewById(R.id.gridcart);
        float sum=0;
        Context context = getApplicationContext();


        GridLayout.LayoutParams param =new GridLayout.LayoutParams();
        param.height = convertDpToPx(context,70);
        param.width = convertDpToPx(context,318);
        param.topMargin = convertDpToPx(context,2);
        param.setGravity(Gravity.CENTER);

        LinearLayout l1=new LinearLayout(this);
        l1.setId(i+2000);
        idofitemsdelete[i]=i+2000;
        l1.setBackgroundColor(getResources().getColor(color.cartback));
        l1.setOrientation(LinearLayout.HORIZONTAL);
        l1.setLayoutParams(param);

        //      SET    IMAGE

        LinearLayout.LayoutParams paramimg = new LinearLayout.LayoutParams(convertDpToPx(context,50),convertDpToPx(context,50));//(LinearLayout.LayoutParams) l1.getLayoutParams();
        paramimg.topMargin=convertDpToPx(context,10);
        paramimg.leftMargin=convertDpToPx(context,10);

        ImageView i1=new ImageView(this);
        int imgno=Integer.parseInt(imagename);
        i1.setImageResource(imgno);
        i1.setLayoutParams(paramimg);

        RelativeLayout r1=new RelativeLayout(this);

        LinearLayout.LayoutParams paramrel = new LinearLayout.LayoutParams(convertDpToPx(context,170),convertDpToPx(context,50));//(LinearLayout.LayoutParams) l1.getLayoutParams();
        paramrel.topMargin=convertDpToPx(context,8);
        paramrel.leftMargin=convertDpToPx(context,10);
        r1.setLayoutParams(paramrel);

        TextView t1=new TextView(this);
        t1.setTextSize(15);
        t1.setText(productname);

        RelativeLayout.LayoutParams paramname = new RelativeLayout.LayoutParams(convertDpToPx(context,100),RelativeLayout.LayoutParams.WRAP_CONTENT);
        paramname.setMargins(0,convertDpToPx(context,5),0,0);
        t1.setLayoutParams(paramname);

        TextView t2=new TextView(this);
        t2.setTextSize(15);
        t2.setText("$"+price);
        RelativeLayout.LayoutParams paramprice = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        paramprice.setMargins(0,convertDpToPx(context,30),0,0);
        t2.setLayoutParams(paramprice);

        //  add ITEMS and Price

        TextView items=new TextView(this);
        items.setText("Items");
        items.setTextColor(getResources().getColor(color.colorPrimary));
        RelativeLayout.LayoutParams paramitem = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        paramitem.setMargins(convertDpToPx(context,90),convertDpToPx(context,5),0,0);
        items.setLayoutParams(paramitem);

        TextView itemscount=new TextView(this);
        itemscount.setText(counts);
        itemscount.setTextColor(getResources().getColor(color.black_overlay));
        RelativeLayout.LayoutParams paramitemcount = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        paramitemcount.setMargins(convertDpToPx(context,135),convertDpToPx(context,5),0,0);
        itemscount.setLayoutParams(paramitemcount);

        TextView total=new TextView(this);
        total.setText("Total");
        total.setTextColor(getResources().getColor(color.black_overlay));
        RelativeLayout.LayoutParams paramtotal = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        paramtotal.setMargins(convertDpToPx(context,90),convertDpToPx(context,30),0,0);
        total.setLayoutParams(paramtotal);

        TextView pricetotal=new TextView(this);
        float num1=Float.parseFloat(price);
        float num2=num1*Integer.parseInt(counts);
        String str1;
        str1 = ""+String.format("%.02f", num2);

        pricetotal.setText("$"+str1);
        pricetotal.setTextColor(getResources().getColor(color.Redcol));
        RelativeLayout.LayoutParams paramtotalprice = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        paramtotalprice.setMargins(convertDpToPx(context,140),convertDpToPx(context,30),0,0);
        pricetotal.setLayoutParams(paramtotalprice);

        r1.addView(t1);
        r1.addView(t2);
        r1.addView(items);
        r1.addView(itemscount);
        r1.addView(total);
        r1.addView(pricetotal);

        //  ADD  Delete;

        final ImageView deleteimg = new ImageView(this);
        deleteimg.setId(i+1000);
        deleteimg.setClickable(true);
        deleteimg.setOnClickListener(
                new ImageView.OnClickListener(){
                    @Override
                    public void onClick(View v)
                    {
                        dbHelper.deletePerticularItem(imagename);
                        Toast.makeText(getApplicationContext(), productname+" Removed", Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(getIntent());
                    }
                }
        );
        deleteimg.setImageResource(R.drawable.trash);

        LinearLayout.LayoutParams paramdel = new LinearLayout.LayoutParams(convertDpToPx(context,25),convertDpToPx(context,25));
        paramdel.setMargins(convertDpToPx(context,30),convertDpToPx(context,20),0,0);

        deleteimg.setLayoutParams(paramdel);

        l1.addView(i1);
        l1.addView(r1);
        l1.addView(deleteimg);

        gridLayout.addView(l1);
       //  Trial   gridLayout.removeViewAt(R.id.addtocartfruit);
        sum=Float.parseFloat(str1);
        return sum;
    }

    public void GetBack(View view)
    {
        Intent intentback = new Intent(cartact.this,activity2.class);
        startActivity(intentback);
    }
    public void deleteAllitems(View view)
    {
        if(dbHelper.numberOfRows()==0)
        {
            Toast.makeText(getApplicationContext(), "Cart is Empty", Toast.LENGTH_SHORT).show();
        }
        else
        {
            dbHelper.deleteItemsAll();
            displayitems();
            Toast.makeText(getApplicationContext(), " Removed All Items", Toast.LENGTH_SHORT).show();
            finish();
            startActivity(getIntent());
        }
    }
    public static int getDPsFromPixels(Context context, int pixels)
    {
        Resources r = context.getResources();
        int dps = Math.round(pixels/(r.getDisplayMetrics().densityDpi/160f));
        return dps;
    }
    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics = getApplicationContext().getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }
    public int convertDpToPx(Context context, int dp) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }

    public void setProceed(View view)
    {
        Intent intentproceed = new Intent(cartact.this,costomerdata.class);
        intentproceed.putExtra("total",numstr);
        startActivity(intentproceed);
    }
}