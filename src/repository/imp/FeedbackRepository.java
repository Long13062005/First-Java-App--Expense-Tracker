/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.imp;

import db.BaseRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ExpenseIncomeEntry;
import model.Feedback;
import model.User;
import repository.IFeedbackRepository;

/**
 *
 * @author TechCare
 */
public class FeedbackRepository implements IFeedbackRepository {

    private BaseRepository database = new BaseRepository();
    private Connection connection = null;
    private PreparedStatement ps;
    private final String SHOW_LIST = "Select * from feedback";
    private final String ADD_FEEDBACK = "INSERT INTO `feedback` (description,user_id) VALUES (?,?)";
    private final String DEL_FEEDBACK = "DELETE FROM EXPENSE WHERE id = ? ";
    private final String FIND_ID_FEEDBACK = "Select * from feedback where id = ? ";

    @Override
    public List<Feedback> showList() {
        List<Feedback> entrys = new ArrayList<>();
        ResultSet resultSet = null;
        connection = database.getConnectDB();

        try {
            String query = SHOW_LIST;
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String description = resultSet.getString("description");
                int userID = resultSet.getInt("user_id");
                Feedback f = new Feedback(id, userID, description);
                entrys.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return entrys;
    }

    @Override
    public boolean addFeedback(Feedback f, User user) {
        connection = database.getConnectDB();

        try {
            ps = connection.prepareStatement(ADD_FEEDBACK);
            ps.setString(1, f.getDescription());
            ps.setInt(2, user.getId());
            int rowsInserted = ps.executeUpdate();

            // Check if the user was successfully inserted
            if (rowsInserted > 0) {
                return true; // User created successfully
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean delFeedback(int id) {
        connection = database.getConnectDB();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DEL_FEEDBACK);
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public Feedback findById(int id) {
        ResultSet resultSet = null;
        Feedback f = null;
        connection = database.getConnectDB();

        try {

            // Assuming FIND_USER_ID is defined somewhere as a constant
            String query = FIND_ID_FEEDBACK;
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            resultSet = ps.executeQuery();

            if (resultSet.next()) {
                int idFind = resultSet.getInt("id");
                String description = resultSet.getString("description");
                int userID = resultSet.getInt("user_id");

                f = new Feedback(id, userID, description);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
            // Handle SQLException appropriately, e.g., throw an exception or log it.
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
                // Handle SQLException appropriately, e.g., throw an exception or log it.
            }
        }
        return f;
    }

}
