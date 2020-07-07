package com.example.search_worker.Entity;

import java.security.PrivilegedAction;
import java.util.PrimitiveIterator;

public class ModelClass
{
    private String usernamestr="",passwordstr="",namestr="",cnicstr="",contactNumberstr="",dateFromstr="",projectsstr="",researchstr="",skilsstr="",educationstr="";
    private String username_password,id;
    public ModelClass()
    {
    }

    public ModelClass(String id,String usernamestr, String passwordstr, String namestr, String cnicstr, String contactNumberstr, String dateFromstr, String projectsstr, String researchstr, String skilsstr, String educationstr)
    {
        this.id=id;
        this.usernamestr = usernamestr;
        this.passwordstr = passwordstr;
        this.namestr = namestr;
        this.cnicstr = cnicstr;
        this.contactNumberstr = contactNumberstr;
        this.dateFromstr = dateFromstr;
        this.projectsstr = projectsstr;
        this.researchstr = researchstr;
        this.skilsstr = skilsstr;
        this.educationstr = educationstr;
        username_password=usernamestr+"_"+passwordstr;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getUsernamestr()
    {
        return usernamestr;
    }

    public void setUsernamestr(String usernamestr)
    {
        this.usernamestr = usernamestr;
    }

    public String getPasswordstr()
    {
        return passwordstr;
    }

    public void setPasswordstr(String passwordstr)
    {
        this.passwordstr = passwordstr;
    }

    public String getNamestr()
    {
        return namestr;
    }

    public void setNamestr(String namestr)
    {
        this.namestr = namestr;
    }

    public String getCnicstr()
    {
        return cnicstr;
    }

    public void setCnicstr(String cnicstr)
    {
        this.cnicstr = cnicstr;
    }

    public String getContactNumberstr()
    {
        return contactNumberstr;
    }

    public void setContactNumberstr(String contactNumberstr)
    {
        this.contactNumberstr = contactNumberstr;
    }

    public String getDateFromstr()
    {
        return dateFromstr;
    }

    public void setDateFromstr(String dateFromstr)
    {
        this.dateFromstr = dateFromstr;
    }

    public String getProjectsstr()
    {
        return projectsstr;
    }

    public void setProjectsstr(String projectsstr)
    {
        this.projectsstr = projectsstr;
    }

    public String getResearchstr()
    {
        return researchstr;
    }

    public void setResearchstr(String researchstr)
    {
        this.researchstr = researchstr;
    }

    public String getSkilsstr()
    {
        return skilsstr;
    }

    public void setSkilsstr(String skilsstr)
    {
        this.skilsstr = skilsstr;
    }

    public String getEducationstr()
    {
        return educationstr;
    }

    public void setEducationstr(String educationstr)
    {
        this.educationstr = educationstr;
    }

    public String getUsername_password()
    {
        return username_password;
    }

    public void setUsername_password(String username,String password)
    {
        this.username_password = username+"_"+password;
    }
}
