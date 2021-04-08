package io.github.plizzzhealme.dao;

import io.github.plizzzhealme.dao.connector.Connector;
import io.github.plizzzhealme.entity.Poll;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class PollDao implements Dao<Poll> {

    private static final Logger LOGGER = Logger.getLogger(UserDao.class);
    private static final String SQL_SELECT = "SELECT * FROM social_poll.question WHERE question.body LIKE ?";

    @Override
    public Optional<Poll> get(String text) {
        Poll poll = new Poll();

        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT)) {

            preparedStatement.setString(1, "%" + text + "%");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    poll.setId(resultSet.getInt(1));
                    poll.setQuestion(resultSet.getString(2));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            LOGGER.error(e.getMessage());
        }

        return Optional.of(poll);
    }

    @Override
    public void add(Poll poll) {
        //todo doodoo
    }
}
