package io.github.plizzzhealme.service;

import io.github.plizzzhealme.dao.DaoFactory;
import io.github.plizzzhealme.entity.Poll;
import io.github.plizzzhealme.entity.User;

public class SelectService {

    public User getUser(String email) {
        return DaoFactory.getUserDao().get(email).orElse(new User());
    }

    public Poll getPoll(String text) {
        return DaoFactory.getPollDao().get(text).orElse(new Poll());
    }
}
