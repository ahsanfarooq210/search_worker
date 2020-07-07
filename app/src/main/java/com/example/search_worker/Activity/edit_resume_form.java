package com.example.search_worker.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.search_worker.Entity.ModelClass;
import com.example.search_worker.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class edit_resume_form extends AppCompatActivity
{
    private String usernamestr="",passwordstr="",namestr="",cnicstr="",contactNumberstr="",dateFromstr="",projectsstr="",researchstr="",skilsstr="",educationstr="";
    private Spinner educatoion;
    private EditText username,password,name,cnic,contactnumber,dateFrom,project,research,skills;
    private ArrayList<String> educationList;
    private ArrayAdapter<String> educationArrayAdapter;
    private DatabaseReference reference;
    private String key,id;
    private ModelClass modelClass;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_resume_form);
        educatoion=findViewById(R.id.eeducation_spinner);

        username=findViewById(R.id.eusername_tf);
        password=findViewById(R.id.epassword_tf);
        name=findViewById(R.id.ename_tf);
        cnic=findViewById(R.id.ecnic_tf);
        contactnumber=findViewById(R.id.econtact_tf);
        dateFrom=findViewById(R.id.edate_and_from_tf);
        project=findViewById(R.id.eprojects_tf);
        research=findViewById(R.id.eresearch_background_tf);
        skills=findViewById(R.id.eskills_tf);
        reference= FirebaseDatabase.getInstance().getReference(getString(R.string.database_resume_reference));
        educationList=new ArrayList<>();
        educationList.add("Metriculation");
        educationList.add("Intermediate");
        educationList.add("Bacholors");
        educationList.add("Masters");
        educationList.add("M phill");
        educationList.add("P hd");
        educationArrayAdapter=new ArrayAdapter(this,R.layout.spinner_text,educationList);
        educationArrayAdapter.setDropDownViewResource(R.layout.spinner_text_dropdown);
        educatoion.setAdapter(educationArrayAdapter);

        Intent intent=getIntent();

        key=intent.getStringExtra("user_pass");

    }

    @Override
    protected void onStart()
    {
        super.onStart();

        Query query=reference.orderByChild("username_password").equalTo(key).limitToFirst(1);
        query.addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                for(DataSnapshot s:dataSnapshot.getChildren())
                {
                    modelClass=s.getValue(ModelClass.class);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });

        if(modelClass!=null)
        {
            username.setText(modelClass.getUsernamestr());
            password.setText(modelClass.getPasswordstr());
            name.setText(modelClass.getNamestr());
            cnic.setText(modelClass.getCnicstr());
            contactnumber.setText(modelClass.getContactNumberstr());
            educationstr=modelClass.getEducationstr();
            dateFromstr=modelClass.getDateFromstr();
            projectsstr=modelClass.getProjectsstr();
            researchstr=modelClass.getResearchstr();
            skilsstr=modelClass.getSkilsstr();
        }
    }


    public void create(View view)
    {
        usernamestr = username.getText().toString().trim();
        if (usernamestr.isEmpty())
        {
            username.setError("please enter a valid username");
            return;
        }

        passwordstr = password.getText().toString().trim();
        if (passwordstr.isEmpty())
        {
            password.setError("please enter password");
            return;
        }

        namestr = name.getText().toString().trim();
        if (namestr.isEmpty())
        {
            name.setError("enter a name");
            return;
        }
        cnicstr = cnic.getText().toString().trim();
        if (cnicstr.isEmpty())
        {
            cnic.setError("enter a cnic");
            return;
        }
        contactNumberstr=contactnumber.getText().toString().trim();
        if(contactNumberstr.isEmpty())
        {
            contactnumber.setError("enter a contact numebr");
            return;
        }
        if(dateFromstr.isEmpty())
        {
            dateFrom.setError("enter your education");
            return;
        }

        if(skills.getText().toString().isEmpty())
        {
            skills.setError("Enter your skill set");
            return;
        }
        else
        {
            skilsstr=skills.getText().toString().trim();
        }
        if(projectsstr=="")
        {
            project.setError("enter a project");
            return;
        }
        if(researchstr=="")
        {
            research.setError("enter your research");
        }


        reference.child(id).child("namestr").setValue(namestr);
        reference.child(id).child("dateFromstr").setValue(dateFromstr);



    }

    public void addResearchButton(View view)
    {

        if(research.getText().toString().isEmpty())
        {
            research.setError("enter your research");
            return;
        }
        else
        {
            researchstr+=research.getText().toString().trim()+";";
        }
        research.setText("");
        Toast.makeText(this, "Research added successfully", Toast.LENGTH_SHORT).show();

    }



    public void addProject(View view)
    {
        if(project.getText().toString().isEmpty())
        {
            project.setError("enter your research");
            return;
        }
        else
        {
            projectsstr+=project.getText().toString().trim()+";";
        }
        project.setText("");
        Toast.makeText(this, "project added successfully", Toast.LENGTH_SHORT).show();
    }

    public void addEducation(View view)
    {
        educationstr += educatoion.getSelectedItem().toString() + ";";
        if (dateFrom.getText().toString().isEmpty())
        {
            dateFrom.setError("enter valid education");
            return;
        } else
        {
            dateFromstr += dateFrom.getText().toString().trim() + ";";
            dateFrom.setText("");
            Toast.makeText(this, "education added successfully", Toast.LENGTH_SHORT).show();
        }
    }

    public void clearEducation(View view)
    {
        educationstr="";
        dateFromstr="";
    }

    public void clearResearch(View view)
    {
        researchstr="";
    }

    public void clearProject(View view)
    {
        projectsstr="";
    }
}