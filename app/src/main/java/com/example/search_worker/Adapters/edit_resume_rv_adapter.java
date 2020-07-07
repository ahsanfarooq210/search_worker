package com.example.search_worker.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.search_worker.Entity.ModelClass;
import com.example.search_worker.R;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class edit_resume_rv_adapter extends RecyclerView.Adapter<edit_resume_rv_adapter.ViewHolder>
{
    private ArrayList<ModelClass> list;
    private Activity context;

    public edit_resume_rv_adapter(ArrayList<ModelClass> list, Activity context)
    {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v= LayoutInflater.from(context).inflate(R.layout.edit_layout_rv_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.username.setText(list.get(position).getUsernamestr());
        holder.name.setText(list.get(position).getNamestr());
        holder.cnic.setText(list.get(position).getCnicstr());
        holder.contact.setText(list.get(position).getContactNumberstr());
        String education="",date="",estr="";
        education=list.get(position).getEducationstr();
        date=list.get(position).getDateFromstr();

        StringTokenizer tokenizereducation=new StringTokenizer(education,";");
        StringTokenizer tokenizerdate=new StringTokenizer(date,";");
        while (tokenizereducation.hasMoreTokens())
        {
            estr+=tokenizereducation.nextToken()+" "+tokenizerdate.nextToken()+"\n";
        }
        holder.education.setText(estr);

        String research=list.get(position).getResearchstr(),rstr="";
        StringTokenizer tokenizerresearch=new StringTokenizer(research,";");
        while (tokenizerresearch.hasMoreTokens())
        {
            rstr+=tokenizerresearch.nextToken()+"\n";
        }
        holder.research.setText(rstr);

        String project,pstr="";
        project=list.get(position).getProjectsstr();

        StringTokenizer projectToken=new StringTokenizer(project,";");
        while(projectToken.hasMoreTokens())
        {
            pstr+=projectToken.nextToken()+"\n";
        }
        holder.projects.setText(pstr);
        holder.skills.setText(list.get(position).getSkilsstr());


    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView username,name,cnic,contact,education,research,projects,skills;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            username=itemView.findViewById(R.id.show_resume_rv_layout_username);
            name=itemView.findViewById(R.id.show_resume_rv_layout_name);
            cnic=itemView.findViewById(R.id.show_resume_rv_layout_cnic);
            contact=itemView.findViewById(R.id.show_resume_rv_layout_contact);
            education=itemView.findViewById(R.id.show_resume_rv_layout_education);
            research=itemView.findViewById(R.id.show_resume_rv_layout_research);
            projects=itemView.findViewById(R.id.show_resume_rv_layout_project);
            skills=itemView.findViewById(R.id.show_resume_rv_layout_skills);
        }
    }
}
