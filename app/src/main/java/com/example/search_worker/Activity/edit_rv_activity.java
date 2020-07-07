package com.example.search_worker.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.search_worker.Adapters.edit_resume_rv_adapter;
import com.example.search_worker.Entity.ModelClass;
import com.example.search_worker.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class edit_rv_activity extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private DatabaseReference reference;
    private ArrayList<ModelClass> list;
    private edit_resume_rv_adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_rv_activity);
        recyclerView=findViewById(R.id.edit_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        reference= FirebaseDatabase.getInstance().getReference(getString(R.string.database_resume_reference));
        list=new ArrayList<>();

        adapter=new edit_resume_rv_adapter(list,this);
    }

    @Override
    protected void onStart()
    {
        super.onStart();

        reference.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                list.clear();
                for(DataSnapshot model:dataSnapshot.getChildren())
                {
                    list.add(model.getValue(ModelClass.class));
                }
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(edit_rv_activity.this, "error in downloading the data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}