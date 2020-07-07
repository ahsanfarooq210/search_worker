package com.example.search_worker.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.search_worker.R;

import java.security.PrivateKey;

public class edit_resume extends AppCompatActivity
{
    private EditText username,password;
    private String user_pass;

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
        if(username.getText().toString().isEmpty())
        {
            username.setError("enter username");
            return;
        }
        if(password.getText().toString().isEmpty())
        {
            password.setError("enter password");
            return;
        }
        user_pass=username.getText().toString().trim()+"_"+password.getText().toString().trim();
        Intent intent=new Intent(edit_resume.this,edit_resume_form.class);
        intent.putExtra("user_pass",user_pass);
        startActivity(intent);


    }
}