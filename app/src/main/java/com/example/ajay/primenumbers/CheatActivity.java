package com.example.ajay.primenumbers;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class CheatActivity extends ActionBarActivity {

    private TextView showcheat;
    private int prime;
    //private int flag=0;
    private int usecheat =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        showcheat = (TextView) findViewById(R.id.cheat_textview);
        Bundle gotBasket= getIntent().getExtras();
        prime=gotBasket.getInt("numberPrime");
        //getPrime();
    }
/*
* method to check whether the number coming from parentactivity is prime or not
*
    public void getPrime()
    {

        showcheat.setText("Number is : " + prime);
        flag=0;
        int n=prime;
        int i;
        for (i = 2; i <= n / 2; i++)
        {
            if (n % i == 0) {
                flag = 1;
                break;
            }
        }
        if (n == 1) {
            flag = 1;
        }
        if(flag == 0)
        {
            Toast.makeText(CheatActivity.this, "" + "Its a prime number", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(CheatActivity.this, "" + "Its not a prime number", Toast.LENGTH_LONG).show();
        }
    }*/

    public void onCheatAnswerClick(View view)
    {

        showcheat.setText("Number is : "+prime);
         int flag=0;
        int n=prime;
        int i;
        for (i = 2; i <= n / 2; i++)
        {
            if (n % i == 0) {
                flag = 1;
                break;
            }
        }
        if (n == 1) {
            flag = 1;
        }
        if(flag == 0)
        {
            Toast.makeText(CheatActivity.this, "" + "Its a prime number", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(CheatActivity.this, "" + "Its not a prime number", Toast.LENGTH_LONG).show();
        }
        usecheat =1;
    }


    /*
    *
    * method is created which will be called on click of back button and response will be send to parent activity to convey wether
    * the desired task is completed or not
    * */
    public void onCheatBackClick(View view)
    {
        Intent mainAct = new Intent(CheatActivity.this, MainActivity.class);
        mainAct.putExtra("cheat_flag",usecheat);
        setResult(RESULT_OK,mainAct);
        finish();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cheat, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
