package model;

import java.util.Date;

public class Task {
    private int ID_Task;
    private int ID_Project;
    private String Name;
    private String Description;
    private boolean Completed;
    private String Notes;
    private Date Deadline;
    private Date Created_At;
    private Date Updated_At;

    public Task(int ID_Task, int ID_Project, String Name, String Description, boolean Completed, String Notes, Date Deadline, Date Created_At, Date Updated_At) {
        this.ID_Task = ID_Task;
        this.ID_Project = ID_Project;
        this.Name = Name;
        this.Description = Description;
        this.Completed = Completed;
        this.Notes = Notes;
        this.Deadline = Deadline;
        this.Created_At = Created_At;
        this.Updated_At = Updated_At;
    }
    public Task() {
        this.Created_At = new Date();
        this.Updated_At = new Date();
    }

    public int getID_Task() {
        return ID_Task;
    }

    public void setID_Task(int ID_Task) {
        this.ID_Task = ID_Task;
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

    public boolean isCompleted() {
        return Completed;
    }

    public void setCompleted(boolean Completed) {
        this.Completed = Completed;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
    }

    public Date getDeadline() {
        return Deadline;
    }

    public void setDeadline(Date Deadline) {
        this.Deadline = Deadline;
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
        return "Task{" + "ID_Task=" + ID_Task + ", ID_Project=" + ID_Project + ", Name=" + Name + ", Description=" + Description + ", Completed=" + Completed + ", Notes=" + Notes + ", Deadline=" + Deadline + ", Created_At=" + Created_At + ", Updated_At=" + Updated_At + '}';
    }
    
}
