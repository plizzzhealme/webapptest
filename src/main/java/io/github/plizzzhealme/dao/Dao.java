package io.github.plizzzhealme.dao;

import java.util.Optional;

public interface Dao<T> {

    Optional<T> get(String param);

    void add(T t);

    //todo void update(T t, String[] params);

    //todo void delete(T t);
}
