package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;

public class ProjectController {
    
    public void save(Project project) {
        String SQL = "INSERT INTO tbl_Projects(Name, Description, Created_At, Updated_At)"
                + "VALUES (?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(SQL);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreated_At().getTime()));
            statement.setDate(4, new Date(project.getUpdated_At().getTime()));
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir projeto" + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    public void update(Project project) {
        String SQL = "UPDATE tbl_Projects SET Name = ?, Description = ?, Created_At = ?, Updated_At = ? "
                + "WHERE ID_Project = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(SQL);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreated_At().getTime()));
            statement.setDate(4, new Date(project.getUpdated_At().getTime()));
            statement.setInt(5, project.getID_Project());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o projeto" + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    public void removebyID(int ID_Project) {
        String SQL = "DELETE FROM tbl_Projects WHERE ID_Project = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(SQL);
            statement.setInt(1, ID_Project);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover o projeto" + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    public List<Project> getAll() {
        String SQL = "SELECT * FROM tbl_Projects";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultset = null;
        List<Project> list_projects = new ArrayList<Project>();
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(SQL);
            resultset = statement.executeQuery();
            
            while(resultset.next()) {
                Project project = new Project();
                project.setID_Project(resultset.getInt("ID_Project"));
                project.setName(resultset.getString("Name"));
                project.setDescription(resultset.getString("Description"));
                project.setCreated_At(resultset.getDate("Created_At"));
                project.setUpdated_At(resultset.getDate("Updated_At"));
                list_projects.add(project);
            }   
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao retornar projetos." + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultset);
        }
        return list_projects;
    }
}
