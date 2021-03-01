package com.zdatbit.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(){
        String inserSql = "insert into user(name,age) values(?,?)";
        jdbcTemplate.update(inserSql,"admin",18);
    }
}
