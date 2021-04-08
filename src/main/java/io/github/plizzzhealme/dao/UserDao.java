package io.github.plizzzhealme.dao;

import io.github.plizzzhealme.dao.connector.Connector;
import io.github.plizzzhealme.entity.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDao implements Dao<User> {

    private static final Logger LOGGER = Logger.getLogger(UserDao.class);
    private static final String SQL_SELECT = "SELECT * FROM user WHERE email = ?";
    private static final String SQL_ADD = "INSERT INTO user (email, name, sex) VALUES (?, ?, ?)";

    @Override
    public Optional<User> get(String email) {
        User user = new User();

        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT)){

            preparedStatement.setString(1, email);

            try (ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()) {
                    user.setId(resultSet.getInt(1));
                    user.setEmail(resultSet.getString(2));
                    user.setName(resultSet.getString(3));
                    user.setYear(resultSet.getInt(4));
                    user.setSex(resultSet.getString(5));
                    user.setPollCount(resultSet.getInt(6));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            LOGGER.error(e.getMessage());
        }

        return Optional.of(user);
    }

    @Override
    public void add(User user) {
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD)){
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getSex());

            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            LOGGER.error(e.getMessage());
            System.out.println(e.getMessage());
        }
    }
}
