package com.example.search_worker.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.search_worker.Entity.ModelClass;
import com.example.search_worker.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Add_resume extends AppCompatActivity
{
    private String usernamestr="",passwordstr="",namestr="",cnicstr="",contactNumberstr="",dateFromstr="",projectsstr="",researchstr="",skilsstr="",educationstr="";
    private Spinner educatoion;
    private EditText username,password,name,cnic,contactnumber,dateFrom,project,research,skills;
    private ArrayList<String> educationList;
    private ArrayAdapter<String> educationArrayAdapter;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_resume);

        educatoion=findViewById(R.id.education_spinner);

        username=findViewById(R.id.username_tf);
        password=findViewById(R.id.password_tf);
        name=findViewById(R.id.name_tf);
        cnic=findViewById(R.id.cnic_tf);
        contactnumber=findViewById(R.id.contact_tf);
        dateFrom=findViewById(R.id.date_and_from_tf);
        project=findViewById(R.id.projects_tf);
        research=findViewById(R.id.research_background_tf);
        skills=findViewById(R.id.skills_tf);
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

        String id=reference.push().getKey();

        ModelClass modelClass=new ModelClass(id,usernamestr,passwordstr,namestr,cnicstr,contactNumberstr,dateFromstr,projectsstr,researchstr,skilsstr,educationstr);
        reference.child(id).setValue(modelClass);
        username.setText("");
        password.setText("");
        name.setText("");
        cnic.setText("");
        contactnumber.setText("");
        dateFrom.setText("");
        project.setText("");
        skills.setText("");
        research.setText("");
        Toast.makeText(this, "Record added succesfully", Toast.LENGTH_SHORT).show();


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
}