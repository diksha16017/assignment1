package com.example.ajay.primenumbers;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import java.util.Random;


public class MainActivity extends ActionBarActivity {

    private TextView enter_question;
    private TextView correct;
    private TextView incorrect;
    private static final String TAG = "MainActivity";
    static final int cheatActivityRequest = 1;
    static final int hintActivityRequest = 2;
    private static final String MESSAGE ="Is 29 A Prime Number ?";
    private int correctscoreInt,incorrectscoreInt;
    private String question,CorrectScore,InCorrectScore;
    //private String save_question,save_correct,save_incorrect;
    private int flag = 0;
    private int color= Color.parseColor("#B2DFDB");
    private int color1= Color.parseColor("#009688");
    int flaghintt  = 0;
    int flagcheatt =0;
    //private int visibleFlag = 0;
    private Button nextBtn,trueBtn,falseBtn,cheatBtn,hintBtn;
    private LinearLayout linear,linear1;

    /* this is by default method which is called when the activity is firstly loaded*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setting back xml file and fetching ids of components from that file
        setContentView(R.layout.activity_main);
        enter_question = (TextView) findViewById(R.id.question_textview);
        correct = (TextView) findViewById(R.id.correct_textview);
        incorrect = (TextView) findViewById(R.id.incorrect_textview);
        nextBtn=(Button)findViewById(R.id.next_button);
        trueBtn=(Button)findViewById(R.id.true_button);
        falseBtn=(Button)findViewById(R.id.false_button);
        hintBtn=(Button)findViewById(R.id.hint_button);
        cheatBtn=(Button)findViewById(R.id.cheat_button);
        linear=(LinearLayout) findViewById(R.id.next_layout);
        linear1=(LinearLayout)findViewById(R.id.btns_layout);
        enter_question.setText(MESSAGE);

    }

    /* by default method present and used for setting action bar menu */
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /* method is created to fetch number from textview string which will be used for checking primality */
    void getNumber() {

        int number;
        question = enter_question.getText().toString();
        String[] question_array = question.split(" ");
        number = Integer.parseInt(question_array[1]);
        checkPrime(number);


    }
    /*  method is made to check primality of number */
    void checkPrime(int n)
    {
        int i;
        flag = 0;
        for (i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                flag = 1;
                break;
            }
        }
        if (n == 1) {
            flag = 1;
        }
    }
    /* method is made which will be called on clicking of false button */
    public void onFalseClick(View view) {



        CorrectScore = correct.getText().toString();
        String[] correct_array = CorrectScore.split(" ");
        correctscoreInt = Integer.parseInt(correct_array[1]);
        InCorrectScore = incorrect.getText().toString();
        String[] incorrect_array = InCorrectScore.split(" ");
        incorrectscoreInt = Integer.parseInt(incorrect_array[1]);

//displaying toast to display correct messages
        getNumber();
        if (flag == 1)
        {
            Toast.makeText(MainActivity.this, "" + "Correct", Toast.LENGTH_LONG).show();
            correctscoreInt+=1;
            correct.setText("Correct "+correctscoreInt);
            //save_correct=correct.getText().toString();
        }
        else
        {
            Toast.makeText(MainActivity.this, "" + "InCorrect", Toast.LENGTH_LONG).show();
            incorrectscoreInt+=1;
            incorrect.setText("InCorrect "+incorrectscoreInt);
            //save_incorrect=incorrect.getText().toString();
        }
        linear.setBackgroundColor(color);
        nextBtn.setVisibility(view.VISIBLE);
        trueBtn.setVisibility(view.INVISIBLE);
        falseBtn.setVisibility(view.INVISIBLE);
        linear1.setBackgroundColor(color1);
        cheatBtn.setVisibility(view.GONE);
    }

    /* method is made which will be called on clicking of true button */
    public void onTrueClick(View view) {


        CorrectScore = correct.getText().toString();
        String[] correct_array = CorrectScore.split(" ");
        correctscoreInt = Integer.parseInt(correct_array[1]);
        InCorrectScore = incorrect.getText().toString();
        String[] incorrect_array = InCorrectScore.split(" ");
        incorrectscoreInt = Integer.parseInt(incorrect_array[1]);
        //displaying toast to display correct messages

        getNumber();
        if (flag == 1)
        {
            Toast.makeText(MainActivity.this, "" + "Incorrect", Toast.LENGTH_LONG).show();
            incorrectscoreInt+=1;
            incorrect.setText("InCorrect "+incorrectscoreInt);
        }
        else
        {
            Toast.makeText(MainActivity.this, "" + "Correct", Toast.LENGTH_LONG).show();
            correctscoreInt+=1;
            correct.setText("Correct "+correctscoreInt);

        }
        linear.setBackgroundColor(color);
        nextBtn.setVisibility(view.VISIBLE);
        trueBtn.setVisibility(view.INVISIBLE);
        falseBtn.setVisibility(view.INVISIBLE);
        linear1.setBackgroundColor(color1);
        cheatBtn.setVisibility(view.GONE);
    }
    /* method is made which will be called on clicking of next button */
    public void onNextClick(View view)
    {

        Random r=new Random();
        int next_number;
        next_number=r.nextInt(1000)+1;
        String newQuestion="Is "+ next_number +" A Prime Number ?";
        enter_question.setText(newQuestion);
        linear1.setBackgroundColor(color);
        trueBtn.setVisibility(view.VISIBLE);
        falseBtn.setVisibility(view.VISIBLE);
        nextBtn.setVisibility(view.INVISIBLE);
        linear.setBackgroundColor(color1);
        cheatBtn.setVisibility(view.VISIBLE);

    }

/*
* this method is made to start new activity ie hintactivity on click of hint button
* */
    public void onHintClick(View view)
    {
        /*
        * intent is used to start new activity
        * */
        Intent hint_activity = new Intent(MainActivity.this,HintActivity.class);
        startActivityForResult(hint_activity,hintActivityRequest);

    }


/**
 * this method is made to start new cheatactivity on click of cheat button
 *
 */

    public void onCheatClick(View view)
    {
        int number;
        question = enter_question.getText().toString();
        String[] question_array = question.split(" ");
        number = Integer.parseInt(question_array[1]);
        Bundle basket = new Bundle();
        basket.putInt("numberPrime", number);
        Intent intent = new Intent(MainActivity.this, CheatActivity.class);
        intent.putExtras(basket);
        startActivityForResult(intent,cheatActivityRequest);


    }

/*
* this method is by default present to check from which child activity parent activity is being interacting
* */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to

        if (requestCode == cheatActivityRequest) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {

                flagcheatt = data.getIntExtra("cheat_flag",0);
                if(flagcheatt == 1)
                {
                    Toast.makeText(MainActivity.this, "" + "hey you have cheated the answer..", Toast.LENGTH_LONG).show();
                }

            }
        }
        else if(requestCode == hintActivityRequest)
        {
            if (resultCode == RESULT_OK) {


                flaghintt = data.getIntExtra("hint_flag",0);
                if(flaghintt == 1)
                {
                    Toast.makeText(MainActivity.this, "" + "hey you have taken a hint", Toast.LENGTH_LONG).show();
                }

            }
        }
    }
/*
* method by default present to store values which will be fetched at time of calling oncreate()
* */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){


        Log.i(TAG, "Inside onSaveInstance");
    }

    /*method by default present and one of the part of activity life cycle*/
    @Override
    public void onStart()
    {
        super.onStart();

        Log.d(TAG, "Inside OnStart");
    }


    /*method by default present and one of the part of activity life cycle*/
    @Override
    public void onPause()
    {
        super.onPause();


        Log.d(TAG,"Inside OnPause");
    }

    /*method by default present and one of the part of activity life cycle*/
    @Override
    public void onResume(){
        super.onResume();


        Log.d(TAG,"Inside OnREsume");

    }
    /*method by default present and one of the part of activity life cycle*/

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "Inside OnSTop");
    }

    /*method by default present and one of the part of activity life cycle*/
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Inside OnDestroy");
    }


/*method by default present and use for action bar settings*/

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


