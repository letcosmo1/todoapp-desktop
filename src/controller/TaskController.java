package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

public class TaskController {
    
    public void save(Task task) {
        String SQL = "INSERT INTO tbl_Tasks(ID_Project, Name, Description, Completed, Notes, Deadline, Created_At, Updated_At)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(SQL);
            statement.setInt(1, task.getID_Project());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreated_At().getTime()));
            statement.setDate(8, new Date(task.getUpdated_At().getTime()));
            statement.execute();
        } catch(Exception e) {
            throw new RuntimeException("Falha ao inserir uma tarefa." + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    public void update(Task task) {
        String SQL = "UPDATE tbl_Tasks SET ID_Project = ?, Name = ?, Description = ?, Completed = ?, Notes = ?, Deadline = ?, Created_At = ?, Updated_At = ? "
                + "WHERE ID_Task = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(SQL);
            statement.setInt(1, task.getID_Project());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreated_At().getTime()));
            statement.setDate(8, new Date(task.getUpdated_At().getTime()));
            statement.setInt(9, task.getID_Task());
            statement.execute();
        } catch(Exception e) {
            throw new RuntimeException("Falha ao atualizar a tarefa" + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement); 
        }
    } 
    
    public void removebyID(int ID_Task) {
        String SQL = "DELETE FROM tbl_Tasks WHERE ID_Task = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(SQL);
            statement.setInt(1, ID_Task);
            statement.execute();
        } catch(Exception e){
            throw new RuntimeException("Erro ao deletar tarefa." + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    public List<Task> getTasksFromProject(int ID_Project) {
        String SQL = "SELECT * FROM tbl_Tasks WHERE ID_Project = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultset = null;
        List<Task> list_tasks = new ArrayList<Task>();
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(SQL);
            statement.setInt(1, ID_Project);
            resultset = statement.executeQuery();
            
            while(resultset.next()) {
                Task task = new Task();
                task.setID_Task(resultset.getInt("ID_Task"));
                task.setID_Project(resultset.getInt("ID_Project"));
                task.setName(resultset.getString("Name"));
                task.setDescription(resultset.getString("Description"));
                task.setCompleted(resultset.getBoolean("Completed"));
                task.setNotes(resultset.getString("Notes"));
                task.setDeadline(resultset.getDate("Deadline"));
                task.setCreated_At(resultset.getDate("Created_At"));
                task.setUpdated_At(resultset.getDate("Updated_At"));
                list_tasks.add(task);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao retornar tarefas." + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultset);
        }
        
        return list_tasks;
    }
}
