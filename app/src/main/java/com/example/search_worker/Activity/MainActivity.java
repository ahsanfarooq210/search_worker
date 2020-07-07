package com.example.search_worker.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ScrollView;

import com.example.search_worker.R;

public class MainActivity extends AppCompatActivity
{
    private ScrollView scrollView;
    private Handler handler;
    Runnable runnable=new Runnable()
    {
        @Override
        public void run()
        {
            scrollView.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing the scroll view
        scrollView=findViewById(R.id.dashboard_scroll_view);

        //initializing the handler for the spalsh screen
        handler=new Handler();

        //splash screen
        handler.postDelayed(runnable,1000);//1 second is the timeout for the splash screen



    }

    public void searchResume(View view)
    {
        startActivity(new Intent(MainActivity.this,edit_rv_activity.class));
    }

    public void editResume(View view)
    {
        startActivity(new Intent(MainActivity.this,edit_resume.class));
    }

    public void addResume(View view)
    {
        startActivity(new Intent(MainActivity.this,Add_resume.class));
    }
}