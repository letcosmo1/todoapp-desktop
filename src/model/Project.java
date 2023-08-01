package model;

import java.util.Date;

public class Project {
    private int ID_Project;
    private String Name;
    private String Description;
    private Date Created_At;
    private Date Updated_At;

    public Project(int ID_Project, String Name, String Description, Date Created_At, Date Updated_At) {
        this.ID_Project = ID_Project;
        this.Name = Name;
        this.Description = Description;
        this.Created_At = Created_At;
        this.Updated_At = Updated_At;
    }
    public Project() {
        this.Created_At = new Date();
        this.Updated_At = new Date();
    }

    public int getID_Project() {
        return ID_Project;
    }

    public void setID_Project(int ID_Project) {
        this.ID_Project = ID_Project;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Date getCreated_At() {
        return Created_At;
    }

    public void setCreated_At(Date Created_At) {
        this.Created_At = Created_At;
    }

    public Date getUpdated_At() {
        return Updated_At;
    }

    public void setUpdated_At(Date Updated_At) {
        this.Updated_At = Updated_At;
    }

    @Override
    public String toString() {
        return this.getName();
    }
    
}
