package com.example.search_worker.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.search_worker.R;

import java.security.PrivateKey;

public class edit_resume extends AppCompatActivity
{
    private EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_resume);

        username=findViewById(R.id.username_tf);
        password=findViewById(R.id.password_tf);
    }

    public void loginButton(View view)
    {
    }
}