package com.example.saloni.quiz;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class QuizActivity extends AppCompatActivity {


    Random r = new Random();
    int num = r.nextInt(1000)+1;

    @Override
    public View findViewById(@IdRes int id) {
        return super.findViewById(id);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView question = (TextView) findViewById(R.id.question_text_view);
        question.setText("Is "+ num + " a Prime Number ?");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void next(View view)
    {
        TextView question = (TextView) findViewById(R.id.question_text_view);
        num=r.nextInt(1000)+1;
        question.setText("Is "+ num + " a Prime Number ?");
    }

    public void yes(View view){
        checktrue(num);}

    public void no(View view)
    {

        checkfalse(num);
    }

   public void checktrue(int n){

        if(n==1)
            Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
        else{
            int flag=1;
        for(int i=2;i<n/2;i++)
        {
            if(n%i==0)
            { flag=0;
            break;}
        }
        if(flag==1)
            Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getApplicationContext(),"InCorrect",Toast.LENGTH_SHORT).show();

    }}
    public void checkfalse(int n){

        if(n==1)
            Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();
        else{
            int flag=1;
            for(int i=2;i<n/2;i++)
            {
                if(n%i==0)
                { flag=0;
                    break;}
            }
            if(flag==1)
                Toast.makeText(getApplicationContext(),"InCorrect",Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();

        }}



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
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