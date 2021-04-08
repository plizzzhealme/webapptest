package io.github.plizzzhealme.dao;

import io.github.plizzzhealme.entity.Poll;
import io.github.plizzzhealme.entity.User;

public class DaoFactory {

    private static Dao<User> userDaoInstance;
    private static Dao<Poll> pollDaoInstance;

    private DaoFactory() {}

    public static Dao<User> getUserDao() {
        if (userDaoInstance == null) {
            userDaoInstance = new UserDao();
        }

        return userDaoInstance;
    }

    public static Dao<Poll> getPollDao() {
        if (pollDaoInstance == null) {
            pollDaoInstance = new PollDao();
        }

        return pollDaoInstance;
    }
}
