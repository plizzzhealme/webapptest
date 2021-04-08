package io.github.plizzzhealme.service;

import io.github.plizzzhealme.dao.DaoFactory;
import io.github.plizzzhealme.entity.User;

public class PostService {

    public void postUser(User user) {
        DaoFactory.getUserDao().add(user);
    }
}
