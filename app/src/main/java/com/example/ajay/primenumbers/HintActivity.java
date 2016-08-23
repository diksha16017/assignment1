package com.example.ajay.primenumbers;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class HintActivity extends ActionBarActivity {

    private TextView showHint;
    int setFlag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);
        showHint = (TextView) findViewById(R.id.hint_textview);
    }

    /*
    *
    * method is created which will be called on click of show hint button
    * */
    public void onShowHintClick(View view)
    {
        showHint.setText("Check whether number is divisible by other number or not except 1 and itself");
        setFlag=1;
    }


    /*
    *
    * method is created which will be called on click of back button and response will be send to parent activity to convey wether
    * the desired task is completed or not
    * */
    public void onHintBackClick(View view)
    {

        Intent mainAct = new Intent(HintActivity.this, MainActivity.class);
        mainAct.putExtra("hint_flag", setFlag);
        setResult(RESULT_OK, mainAct);
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hint, menu);
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
